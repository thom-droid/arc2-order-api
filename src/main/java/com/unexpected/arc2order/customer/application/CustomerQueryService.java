package com.unexpected.arc2order.customer.application;

import com.unexpected.arc2order.customer.domain.Customer;
import com.unexpected.arc2order.customer.infrastructure.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerQueryService {

    private final CustomerRepository customerRepository;

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
