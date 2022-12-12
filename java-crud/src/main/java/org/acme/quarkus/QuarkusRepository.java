package org.acme.quarkus;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuarkusRepository implements PanacheRepository<Quarkus> {
}
