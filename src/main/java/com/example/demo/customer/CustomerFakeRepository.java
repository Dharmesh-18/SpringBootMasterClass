package com.example.demo.customer;


import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L, "James Bond"),
                new Customer(2L, "Black Panther")
        );
    }
}
