package io.lhysin.spring.cloud.function.aws;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudFunctionAwsApplication {

    /*
     * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
     * in the POM to ensure boot plug-in makes the correct entry
     */
    public static void main(String[] args) {
        // empty unless using Custom runtime at which point it should include
        // SpringApplication.run(SpringCloudFunctionAwsApplication.class, args);
    }

}
