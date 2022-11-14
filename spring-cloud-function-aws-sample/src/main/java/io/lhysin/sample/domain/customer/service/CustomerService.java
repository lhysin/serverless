package io.lhysin.sample.domain.customer.service;

import io.lhysin.sample.domain.customer.dto.CustomerDto;
import io.lhysin.sample.domain.customer.entity.Customer;
import io.lhysin.sample.domain.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;

  public void create(CustomerDto.CustomerReq req) {
    Customer customer = Customer.builder()
            .firstName(req.getFirstName())
            .lastName(req.getLastName())
            .age(req.getAge())
            .build();
    customerRepository.save(customer);
  };

  public List<CustomerDto.CustomerRes> findAll() {
    return customerRepository.findAll().stream()
            .map(customer -> CustomerDto.CustomerRes.builder()
                    .age(customer.getAge())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .build())
            .collect(Collectors.toList());
  }

}