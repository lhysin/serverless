package io.lhysin.function.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

    @Data
    @Builder
    public static class Req {
        private String id;
        private String age;
        private String firstName;
        private String lastName;
    }

    @Data
    @Builder
    public static class Res {
        private String id;
        private String age;
        private String firstName;
        private String lastName;
    }
}