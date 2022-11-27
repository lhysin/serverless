package io.lhysin.spring.cloud.function.aws.function;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class ExampleFunction {

    @Bean
    public Function<Flux<String>, Flux<String>> uppercase() {
        return flux -> flux.map(value -> value.toUpperCase());
    }

    @Bean
    public Supplier<String> randomString() {
        return () -> UUID.randomUUID().toString();
    }
}
