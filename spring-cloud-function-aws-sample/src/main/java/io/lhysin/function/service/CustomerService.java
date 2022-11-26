package io.lhysin.function.service;

import io.lhysin.function.dto.CustomerDto;
import io.lhysin.function.entity.Customer;
import io.lhysin.function.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void create(CustomerDto.Req req) {
        Customer customer = Customer.builder()
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .age(req.getAge())
                .build();
        customerRepository.save(customer);
    }

    public CustomerDto.Res findById(CustomerDto.Req req) {
        Customer customer = customerRepository.findById(req.getId()).orElseThrow();
        return CustomerDto.Res.builder()
                .id(customer.getId())
                .age(customer.getAge())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }


    public List<CustomerDto.Res> findAll() {
        return customerRepository.findAll().stream()
                .map(customer -> CustomerDto.Res.builder()
                        .age(customer.getAge())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .build())
                .collect(Collectors.toList());
    }

}