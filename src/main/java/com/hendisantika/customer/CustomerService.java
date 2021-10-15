package com.hendisantika.customer;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-customer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/10/21
 * Time: 06.15
 */
@ApplicationScoped
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final Logger logger;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, Logger logger) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.logger = logger;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDomain)
                .collect(Collectors.toList());
    }

    public Optional<Customer> findById(Integer customerId) {
        return customerRepository.findByIdOptional(customerId).map(customerMapper::toDomain);
    }


}
