package io.lhysin.function.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Customer {
    @Id
    private String id;
    private String age;
    private String firstName;
    private String lastName;
}