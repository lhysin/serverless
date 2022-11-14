package io.lhysin.sample.domain.customer.handler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import io.lhysin.sample.domain.customer.dto.CustomerDto;
import io.lhysin.sample.domain.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerHandler {

    private final CustomerService customerService;
    private final Gson gson;

    @Bean
    public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> findAll() {
        return value -> {
            log.debug(value.getBody());

            APIGatewayProxyResponseEvent res = new APIGatewayProxyResponseEvent();

            List<CustomerDto.CustomerRes> a = customerService.findAll();

            String b = gson.toJson(a);

            res.setBody(b);

            return res;

        };
    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> create() {
        return value -> {

            APIGatewayProxyResponseEvent res = new APIGatewayProxyResponseEvent();

            CustomerDto.CustomerReq req = gson.fromJson(value.getBody(), CustomerDto.CustomerReq.class);
            customerService.create(req);

            res.setStatusCode(200);
            res.setHeaders(createResultHeader());

            return res;

        };
    }

    private Map<String, String> createResultHeader() {
        log.info("Execute createResultHeader method");
        Map<String, String> resultHeader = new HashMap<>();
        resultHeader.put("Content-Type", "application/json");

        return resultHeader;
    }

}
