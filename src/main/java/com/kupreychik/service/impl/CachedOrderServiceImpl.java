package com.kupreychik.service.impl;

import com.kupreychik.model.Order;
import com.kupreychik.repository.CustomerRepository;
import com.kupreychik.repository.OrdersRepository;

import java.util.List;

public class CachedOrderServiceImpl extends OrderServiceImpl{
    public CachedOrderServiceImpl(OrdersRepository ordersRepository, CustomerRepository customerRepository) {
        super(ordersRepository, customerRepository);
    }

    @Override
    public List<Order> getAllOrders(int page, int size) {
        return super.getAllOrders(page, size);
    }
}
