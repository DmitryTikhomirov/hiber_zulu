package com.kupreychik.repository;

import com.kupreychik.model.Device;
import com.sun.jdi.connect.Connector.StringArgument;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class DevicesRepository {
    private final SessionFactory factory;

    public DevicesRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public Optional<Device> getById(long id) {
        try (Session session = factory.openSession()) {
            Device device = session.get(Device.class, id);
            return Optional.ofNullable(device);
        }
    }

    public List<Device> getAll() {
        try (Session session = factory.openSession()) {
            Query<Device> query = session.createQuery("from Device", Device.class);
            return query.list();
        }
    }

    public Device add(Device device) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(device);
            transaction.commit();
        }

        return device;
    }

    public void remove(Device device) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(device);
            transaction.commit();
        }
    }
}
