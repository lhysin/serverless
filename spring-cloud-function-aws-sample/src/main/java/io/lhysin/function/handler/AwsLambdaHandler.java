package io.lhysin.function.handler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyResponseEvent;
import io.lhysin.function.dto.CustomerDto;
import io.lhysin.function.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
@Slf4j
public class AwsLambdaHandler extends SpringBootRequestHandler<APIGatewayV2ProxyRequestEvent, APIGatewayV2ProxyResponseEvent> {


    private final CustomerService customerService;

    // GET localhost:8080/customers -> returns all the Customers:
    @Bean
    public Function<APIGatewayV2ProxyRequestEvent, APIGatewayV2ProxyResponseEvent> test() {
        return req -> {
            APIGatewayV2ProxyResponseEvent res = new APIGatewayV2ProxyResponseEvent();
            res.setBody(req.getBody());
            return res;
        };
    }

    // GET localhost:8080/findAllCustomer -> returns all the Customers:
    @Bean
    public Supplier<List<CustomerDto.Res>> findAllCustomer() {
        return () -> customerService.findAll();
    }

    // GET localhost:8080/findCustomerById/2 -> returns a particular Customer
    @Bean
    public Function<CustomerDto.Req, CustomerDto.Res> findCustomerById() {
        return req -> customerService.findById(req);
    }

    // POST localhost:8080/createCustomer -> posts a new Customer and returns all of them
    // Consumer<Customer> would supply the POST with no output
    @Bean
    public Consumer<CustomerDto.Req> createCustomer() {
        return req -> {
            customerService.create(req);
        };
    }

}