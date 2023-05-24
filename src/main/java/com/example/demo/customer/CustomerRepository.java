package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Primary
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomer() {

        // TODO: connect to real DB
        return Collections.emptyList();
    }
}
