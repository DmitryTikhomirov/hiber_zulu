package com.kupreychik.providers.xml;

import com.kupreychik.providers.SessionProvider;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class XmlConfigSessionProvider implements SessionProvider {

    @Override
    public SessionFactory getSessionFactory() {
        return new Configuration()
                .configure()
                .buildSessionFactory();
    }
}
