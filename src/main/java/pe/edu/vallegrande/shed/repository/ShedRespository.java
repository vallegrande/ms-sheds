package pe.edu.vallegrande.shed.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pe.edu.vallegrande.shed.model.Shed;
import reactor.core.publisher.Flux;

public interface ShedRespository extends ReactiveCrudRepository<Shed, Long> {
    Flux<Shed> findByStatus(Character status);
}
