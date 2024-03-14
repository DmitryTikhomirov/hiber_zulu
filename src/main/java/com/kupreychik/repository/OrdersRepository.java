package com.kupreychik.repository;

import com.kupreychik.model.Order;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

@RequiredArgsConstructor
public class OrdersRepository {

    private final SessionFactory factory;

    public static final String FIND_ALL_ORDERS = """
            select o from Order o join fetch o.customer
            """;

    public List<Order> findAllOrders(int limit, int offset) {
        try (Session session = factory.openSession()) {
            Query<Order> query = session.createQuery(FIND_ALL_ORDERS, Order.class);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            return query.list();
        }
    }

    public void createOrder(Order orderToSave) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(orderToSave);
            transaction.commit();
        }
    }
}
