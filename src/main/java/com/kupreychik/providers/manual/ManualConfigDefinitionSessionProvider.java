package com.kupreychik.providers.manual;

import com.kupreychik.model.Device;
import com.kupreychik.providers.SessionProvider;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class ManualConfigDefinitionSessionProvider implements SessionProvider {

    private String filePath;
    public ManualConfigDefinitionSessionProvider(String filePath) {
        this.filePath = filePath;
    }

    private Properties properties;
    public ManualConfigDefinitionSessionProvider(Properties properties) {
        this.properties = properties;
    }

    @Override
    public SessionFactory getSessionFactory() {
        if (filePath != null) {
            return new Configuration()
                    .configure(filePath)
                    .addAnnotatedClass(Device.class)
                    .buildSessionFactory();
        } else {
            return new Configuration()
                    .addAnnotatedClass(Device.class)
                    .addProperties(properties)
                    .buildSessionFactory();
        }

    }
}
