package com.kupreychik.service;

import com.kupreychik.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders(int page, int size);

    void createOrder(Long customerId);
}
