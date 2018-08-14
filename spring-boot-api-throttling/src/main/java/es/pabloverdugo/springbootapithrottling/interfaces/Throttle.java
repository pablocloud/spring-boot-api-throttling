package es.pabloverdugo.springbootapithrottling.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Throttle {

    int maxPerSecond() default 1;

    int maxPerMinute() default 100;

    int maxPerHour() default 1000;

    int maxPerDay() default 10000;

}
