package io.lhysin.spring.cloud.function.aws.function;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@Slf4j
public class ExampleFunction implements ApplicationContextInitializer<GenericApplicationContext> {

    /**
     *  Rewrite Function to Functional Style
     * Now that we have created the function with traditional Bean definition style, we can now rewrite the application by using
     * the functional Bean definition style. The code is available in branch feature/function-with-functional-style.
     *
     * Reason for choosing the functional style above the traditional style is the major improvement in startup time.
     * In our example, the startup time with traditional Bean style is about 1s and with the functional style about 250ms.
     *
     * We need to change the following in order to rewrite the function:
     *
     * @SpringBootApplication becomes @SpringBootConfiguration, we do not enable Spring Boot autoconfiguration with this, but mark the class as an entry point;
     * The main class becomes a ApplicationContextInitializer;
     * The SpringApplication becomes a FunctionalSpringApplication which is a subclass of SpringApplication;
     * We remove the @Bean annotation and implement the initialize method and register the bean(s) over here.
     *
     * @param context the application to configure
     */
    @Override
    public void initialize(GenericApplicationContext context) {
        log.debug("ApplicationContextInitializer !!!");
//        context.registerBean("consumer", FunctionRegistration.class,
//                () -> new FunctionRegistration<>(consumer())
//                        .type(FunctionType.of(String.class)));
//
//        context.registerBean("uppercase", FunctionRegistration.class,
//                () -> new FunctionRegistration<>(uppercase())
//                        .type(FunctionType.from(String.class).to(String.class)));
//
//        context.registerBean("randomString", FunctionRegistration.class,
//                () -> new FunctionRegistration<>(randomString())
//                        .type(FunctionType.from(String.class)));
    }

    @Bean
    public Consumer<String> consumer() {
        log.debug("consumer INIT!!!!!!!!");
        return str -> {};
    }

    @Bean
    public Function<String, String> uppercase() {
        log.debug("uppercase INIT!!!!!!!!");
        return str -> str.toUpperCase();
    }

    @Bean
    public Supplier<String> randomString() {
        log.debug("randomString INIT!!!!!!!!");
        return () -> "SUCESS RESPONSE : " + UUID.randomUUID().toString();
    }

}
