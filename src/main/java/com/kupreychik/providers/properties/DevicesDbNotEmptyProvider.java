package com.kupreychik.providers.properties;

import com.kupreychik.model.Device;
import com.kupreychik.providers.SessionProvider;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class DevicesDbNotEmptyProvider implements SessionProvider {

    @Override
    public SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/demo");
        properties.setProperty("hibernate.connection.username", "anton");
        properties.setProperty("hibernate.connection.password", "anton");

        return new Configuration()
                .addProperties(properties)
                .addAnnotatedClass(Device.class)
                .buildSessionFactory();
    }
}
