package io.lhysin.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Map;

public class OracleHealthCheckHandler implements RequestHandler<Void, Void> {

	private static final Logger LOG = Logger.getLogger(OracleHealthCheckHandler.class);

	@Override
	public Void handleRequest(Void input, Context context) {
		LOG.info("start OracleHealthCheckHandler!");
		return null;
	}
}
