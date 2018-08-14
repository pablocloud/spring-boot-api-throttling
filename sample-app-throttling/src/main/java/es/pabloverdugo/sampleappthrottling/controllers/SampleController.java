package es.pabloverdugo.sampleappthrottling.controllers;

import es.pabloverdugo.springbootapithrottling.interfaces.Throttle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Throttle(maxPerSecond = 2, maxPerMinute = 10, maxPerHour = 100, maxPerDay = 1000)
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String sample() {
        return "Hello there";
    }

}
