/*
package com.piggymetrics.accountv2.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Produces;

@ApplicationScoped
public class EntityManagerProvider {

    @Produces
    public EntityManager createEntityManager() {
        return Persistence
                .createEntityManagerFactory("restapi-unit")
                .createEntityManager();
    }

    public void close(EntityManager entityManager) {
        entityManager.close();
    }
}
*/
