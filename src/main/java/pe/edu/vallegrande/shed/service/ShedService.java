package pe.edu.vallegrande.shed.service;

import pe.edu.vallegrande.shed.model.Shed;

import org.springframework.stereotype.Service;
import pe.edu.vallegrande.shed.repository.ShedRespository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShedService {

    private final ShedRespository shedRepository;

    // Constructor para inyectar el repositorio
    public ShedService(ShedRespository shedRepository) {
        this.shedRepository = shedRepository;
    }

    // Método para guardar un nuevo Shed
    public Mono<Shed> save(Shed shed) {
        return shedRepository.save(shed);
    }

    // Método para actualizar un Shed existente
    public Mono<Shed> update(Shed shed) {
        return shedRepository.save(shed);
    }

    // Método para eliminar un Shed por ID (eliminación definitiva)
    public Mono<Void> deleteById(Long id) {
        return shedRepository.deleteById(id);
    }

    // Método para inactivar un Shed (cambiar el estado a 'I')
    public Mono<Shed> inactivate(Long id) {
        return shedRepository.findById(id) // Buscar el Shed por su ID
                .flatMap(shed -> {
                    shed.setStatus('I'); // Cambiar el estado a 'I' (inactivo)
                    return shedRepository.save(shed); // Guardar los cambios
                });
    }

    // Método para activar un Shed (cambiar el estado a 'A')
    public Mono<Shed> activate(Long id) {
        return shedRepository.findById(id) // Buscar el Shed por su ID
                .flatMap(shed -> {
                    shed.setStatus('A'); // Cambiar el estado a 'A' (activo)
                    return shedRepository.save(shed); // Guardar los cambios
                });
    }

    // Método para encontrar un Shed por ID
    public Mono<Shed> findById(Long id) {
        return shedRepository.findById(id);
    }

    // Método para obtener todos los Sheds
    public Flux<Shed> findAll() {
        return shedRepository.findAll();
    }

    // Método para obtener Sheds por su estado ('A' o 'I')
    public Flux<Shed> findByStatus(Character status) {
        return shedRepository.findByStatus(status);
    }
}
