package com.kupreychik.providers.properties;

import com.kupreychik.model.Device;
import com.kupreychik.providers.SessionProvider;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PropertiesSessionProvider implements SessionProvider {

    @Override
    public SessionFactory getSessionFactory() {
        return new Configuration()
                .addAnnotatedClass(Device.class)
                .buildSessionFactory();
    }
}
