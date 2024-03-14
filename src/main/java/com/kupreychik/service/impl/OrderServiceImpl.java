package com.kupreychik.service.impl;

import com.kupreychik.model.Customer;
import com.kupreychik.model.Order;
import com.kupreychik.repository.CustomerRepository;
import com.kupreychik.repository.OrdersRepository;
import com.kupreychik.service.OrderService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<Order> getAllOrders(int page, int size) {
        var limit = size;
        var offset = size * page;
        return ordersRepository.findAllOrders(limit, offset);
    }

    @Override
    public void createOrder(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new IllegalArgumentException("Customer not found");
        } else {
            Order order = buildOrder(customer.get());
            ordersRepository.createOrder(order);
        }
    }

    private Order buildOrder(Customer customer) {
        return Order.builder()
                .customer(customer)
                .build();
    }
}
