package io.lhysin.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.extern.slf4j.Slf4j;

import static io.lhysin.aws.lambda.AwsLambdaApplication.main;

@Slf4j
public class AnotherHandler implements RequestHandler<Void, Void> {

	@Override
	public Void handleRequest(Void input, Context context) {

		log.debug("start AnotherHandler! : {}", context.toString());

		// Spring Java config
		String[] args = {"--spring.batch.job.names=anotherJob"};
		main(args);

		log.debug("end AnotherHandler!");
		return null;
	}

}
