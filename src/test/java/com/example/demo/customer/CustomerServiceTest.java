package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        //give
        Customer jamila = new Customer(1L, "Jamila", "hello", "jamila@mail.com");
        Customer goal = new Customer(2L, "goal", "hello_hello", "goal@mail.com");

        customerRepository.saveAll(Arrays.asList(jamila, goal));

        //when
        List<Customer> customers = underTest.getCustomers();

        //then
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        // given
        Customer jamila = new Customer(1L, "Jamila", "hello", "jamila@mail.com");
        customerRepository.save(jamila);

        //when
        Customer actual = underTest.getCustomer(1L);

        //then
        assertEquals(1L, actual.getId());
        assertEquals("Jamila", actual.getName());
        assertEquals("hello", actual.getPassword());
        assertEquals("jamila@mail.com", actual.getEmail());
    }
}