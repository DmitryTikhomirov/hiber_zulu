package com.kupreychik.repository;

import com.kupreychik.model.Customer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomerRepository {

    private final SessionFactory factory;

    public Optional<Customer> findById(Long id) {
        try (Session session = factory.openSession()) {
            Customer device = session.get(Customer.class, id);
            return Optional.ofNullable(device);
        }
    }

}
