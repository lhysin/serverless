package io.lhysin.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.extern.slf4j.Slf4j;

import static io.lhysin.aws.lambda.AwsLambdaApplication.main;

@Slf4j
public class OracleHealthCheckHandler implements RequestHandler<Void, Void> {

	@Override
	public Void handleRequest(Void input, Context context) {

		log.debug("start OracleHealthCheckHandler! : {}", context.toString());

		// Spring Java config
		String[] args = {"--spring.batch.job.names=oracleHealthCheckJob"};
		main(args);

		log.debug("end OracleHealthCheckHandler!");
		return null;
	}

}
