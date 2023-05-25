package com.example.demo.customer;


import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "password123", "email@gmail.co"),
                new Customer(2L, "Black Panther", "password12345", "email@gmail.co")
        );
    }
}
