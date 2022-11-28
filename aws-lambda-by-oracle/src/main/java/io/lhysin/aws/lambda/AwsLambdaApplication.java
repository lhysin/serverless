package io.lhysin.aws.lambda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
public class AwsLambdaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AwsLambdaApplication.class, args);
    }

    public static class Test {

    }

}
