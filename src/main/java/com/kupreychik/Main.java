package com.kupreychik;

import com.kupreychik.model.Order;
import com.kupreychik.providers.SessionProvider;
import com.kupreychik.providers.properties.CustomersDbProvider;
import com.kupreychik.repository.CustomerRepository;
import com.kupreychik.repository.OrdersRepository;
import com.kupreychik.service.OrderService;
import com.kupreychik.service.impl.CachedOrderServiceImpl;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionProvider sessionProvider = new CustomersDbProvider();
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        OrdersRepository ordersRepository = new OrdersRepository(sessionFactory);
        CustomerRepository customerRepository = new CustomerRepository(sessionFactory);
        OrderService orderService = new CachedOrderServiceImpl(ordersRepository, customerRepository);

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter customer id");
        var customerId = scanner.nextLong();

        orderService.createOrder(customerId);

        System.out.println("enter page");
        var page = scanner.nextInt();
        System.out.println("enter size");
        var size = scanner.nextInt();

        var result = orderService.getAllOrders(page, size);

        for (Order order : result) {
            System.out.println(order);
        }

    }
}
