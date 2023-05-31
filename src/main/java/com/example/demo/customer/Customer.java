package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;


@Entity
@Table
public class Customer {

    @Id
    private Long id;

    @NotBlank(message = "name must not be null or empty")
    private String name;

    @NotBlank(message = "password must not be null or empty")
    @JsonProperty(access = WRITE_ONLY)
    private String password;

    @NotBlank(message = "email must not be null or empty")
    @Email
    @Size(max = 50)
    private String email;

    public Customer() {
    }

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }

//    @JsonProperty("customer_name")
    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
