package io.lhysin.sample.domain.customer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Customer {
  @Id
  private String id;

  private Long age;
  private String firstName;
  private String lastName;
}