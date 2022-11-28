package io.lhysin.spring.cloud.function.aws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@Slf4j
@SpringBootApplication
public class SpringCloudFunctionAwsApplication {

    /*
     * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
     * in the POM to ensure boot plug-in makes the correct entry
     */
    public static void main(String[] args) {
        log.debug("MAIN !!!");
        // empty unless using Custom runtime at which point it should include
        SpringApplication.run(SpringCloudFunctionAwsApplication.class, args);
    }

}
