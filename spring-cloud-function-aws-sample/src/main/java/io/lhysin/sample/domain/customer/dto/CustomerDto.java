package io.lhysin.sample.domain.customer.dto;

import lombok.*;

@Data
@Builder
public class CustomerDto {

  @Data
  @Builder
  public static class CustomerReq {
    private Long age;
    private String firstName;
    private String lastName;
  }

  @Data
  @Builder
  public static class CustomerRes {
    private Long age;
    private String firstName;
    private String lastName;
  }
}