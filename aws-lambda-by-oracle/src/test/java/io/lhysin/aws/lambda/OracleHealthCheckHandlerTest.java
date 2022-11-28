package io.lhysin.aws.lambda;

import io.lhysin.aws.lambda.handler.OracleHealthCheckHandler;

public class OracleHealthCheckHandlerTest {

    public void context() {
        new OracleHealthCheckHandler().handleRequest(null, null);
    }
}
