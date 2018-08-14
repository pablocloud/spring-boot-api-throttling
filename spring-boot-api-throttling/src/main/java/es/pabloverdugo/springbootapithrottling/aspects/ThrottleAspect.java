package es.pabloverdugo.springbootapithrottling.aspects;

import es.pabloverdugo.springbootapithrottling.domain.ApiCall;
import es.pabloverdugo.springbootapithrottling.exceptions.MaxRequestException;
import es.pabloverdugo.springbootapithrottling.interfaces.Throttle;
import es.pabloverdugo.springbootapithrottling.repositories.ApiCallRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class ThrottleAspect {

    private final ApiCallRepository apiCallRepository;

    private final static int SECOND_PERIOD = -1;
    private final static int MINUTE_PERIOD = -60;
    private final static int HOUR_PERIOD = -3600;
    private final static int DAY_PERIOD = -86400;

    @Autowired
    public ThrottleAspect(ApiCallRepository apiCallRepository) {
        this.apiCallRepository = apiCallRepository;
    }

    @Pointcut(value = "" +
            "execution(* *.*(..)) && " +
            "@annotation(es.pabloverdugo.springbootapithrottling.interfaces.Throttle)")
    private void checkApiPointCut() {

    }

    @Before(value = "checkApiPointCut()")
    private void checkApiRates(JoinPoint joinPoint) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Throttle throttle = method.getAnnotation(Throttle.class);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String apiKey;
        apiKey = request.getHeader("apiKey");
        if (apiKey == null) {
            apiKey = request.getParameter("apiKey");
        }
        if (apiKey == null) {
            throw new Exception("Not authenticated. Missing apiKey header or param.");
        }
        //TODO: here there should be auth methods.
        int maxPerSecond = throttle.maxPerSecond();
        int maxPerMinute = throttle.maxPerMinute();
        int maxPerHour = throttle.maxPerHour();
        int maxPerDay = throttle.maxPerDay();
        this.checkCalls(maxPerSecond, apiKey, SECOND_PERIOD);
        this.checkCalls(maxPerMinute, apiKey, MINUTE_PERIOD);
        this.checkCalls(maxPerHour, apiKey, HOUR_PERIOD);
        this.checkCalls(maxPerDay, apiKey, DAY_PERIOD);
        apiCallRepository.save(new ApiCall(apiKey, new Date().getTime()));
        System.out.println("Total calls : " + apiCallRepository.findAllByApiKey(apiKey).size());
    }

    private void checkCalls(int max, String apiKey, int since) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, since);
        List<ApiCall> calls = apiCallRepository
                .findAllByTimeStampGreaterThanAndTimeStampLessThanAndApiKey(calendar.getTime().getTime(), new Date().getTime(), apiKey);
        if (calls.size() + 1 > max) {
            throw new MaxRequestException(max, calls.size(), since);
        }
    }

}
