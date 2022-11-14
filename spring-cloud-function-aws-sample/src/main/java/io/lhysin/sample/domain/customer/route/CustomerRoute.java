package io.lhysin.sample.domain.customer.route;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.lhysin.sample.domain.customer.handler.CustomerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class CustomerRoute {

    private final CustomerHandler customerHandler;

/*    @Bean
    RouterFunction<ServerResponse> createRouter() {
        return route(POST("/v1/customers"), request ->{
            APIGatewayProxyRequestEvent req = new APIGatewayProxyRequestEvent();

            req.setBody("{\n" +
                    "\"age\": 20,\n" +
                    "\"firstName\": \"John\",\n" +
                    "\"lastName\": \"Wick\"\n" +
                    "}");

            APIGatewayProxyResponseEvent res = customerHandler.create().apply(req);

            return ok().body(fromValue(res.getBody()));
        });
    }
    @Bean
    RouterFunction<ServerResponse> findAllRouter() {
        return route(GET("/v1/customers"), request ->{
            APIGatewayProxyRequestEvent req = new APIGatewayProxyRequestEvent();

            APIGatewayProxyResponseEvent res = customerHandler.findAll().apply(req);

            return ok().body(fromValue(res.getBody()));
        });
    }*/

}
