package io.lhysin.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.lhysin.aws.lambda.AwsLambdaApplication;
import io.lhysin.aws.lambda.config.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

import static io.lhysin.aws.lambda.AwsLambdaApplication.main;

@Slf4j
public class OracleHealthCheckHandler implements RequestHandler<Void, Void> {

	@Override
	public Void handleRequest(Void input, Context context) {
		log.debug("start OracleHealthCheckHandler!");

		// Spring Java config
		String[] args = {""};
		main(args);


		log.debug("end OracleHealthCheckHandler!");
		return null;
	}
}
