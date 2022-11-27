package io.lhysin.spring.cloud.function.aws;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@SpringBootTest(classes = SpringCloudFunctionAwsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class SpringCloudFunctionAwsApplicationTests {

    @Autowired
    private TestRestTemplate rest;

    /**
     * @RequestMapping("/**")
     * org.springframework.cloud.function.web.mvc.FunctionController
     * @throws Exception
     */
    @Test
    public void uppercaseTest() throws Exception {
        ResponseEntity<String> result = this.rest.exchange(
                RequestEntity.post(new URI("/uppercase")).body("hello"), String.class);
        log.debug(result.getBody());
    }

    @Test
    public void randomStringTest() throws Exception {
        ResponseEntity<String> result = this.rest.exchange(
                RequestEntity.get(new URI("/randomString")).build(), String.class);
        log.debug(result.getBody());
    }

}
