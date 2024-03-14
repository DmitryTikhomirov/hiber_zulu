package com.kupreychik.providers;

import org.hibernate.SessionFactory;

public interface SessionProvider {

    SessionFactory getSessionFactory();
}
