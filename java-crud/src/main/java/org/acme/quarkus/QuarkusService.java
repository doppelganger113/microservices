package org.acme.quarkus;

import io.opentelemetry.instrumentation.annotations.WithSpan;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class QuarkusService {

    @Inject
    QuarkusRepository quarkusRepository;

    @WithSpan("getAll")
    public List<Quarkus> getAll() {
        return quarkusRepository.findAll().stream().toList();
    }

    public Quarkus add(Quarkus quarkus) {
        quarkusRepository.persist(quarkus);
        return quarkus;
    }

    public void delete(Long id) {
        quarkusRepository.deleteById(id);
    }
}
