package es.pabloverdugo.sampleappthrottling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"es.pabloverdugo"})
public class SampleAppThrottlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleAppThrottlingApplication.class, args);
    }
}
