package pe.edu.vallegrande.shed.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.shed.model.Shed;
import pe.edu.vallegrande.shed.service.ShedService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sheds")
public class ShedRest {

    private final ShedService shedService;

    // Constructor para inyectar el servicio
    public ShedRest(ShedService shedService) {
        this.shedService = shedService;
    }

    // Obtener todos los sheds
    @GetMapping
    public Flux<Shed> getAllSheds() {
        return shedService.findAll();
    }

    // Obtener un shed por ID
    @GetMapping("/{id}")
    public Mono<Shed> getShedById(@PathVariable Long id) {
        return shedService.findById(id);
    }

    // Crear un nuevo shed
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Shed> createShed(@RequestBody Shed shed) {
        return shedService.save(shed);
    }

    // Actualizar un shed existente
    @PutMapping("/{id}")
    public Mono<Shed> updateShed(@PathVariable Long id, @RequestBody Shed shed) {
        shed.setId(id); // Asegura que el ID del shed se establezca correctamente
        return shedService.update(shed);
    }

    // Eliminar un shed por ID (definitivamente)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteShed(@PathVariable Long id) {
        return shedService.deleteById(id);
    }


    // Obtener sheds por estado ('A' o 'I')
    @GetMapping("/status/{status}")
    public Flux<Shed> getShedsByStatus(@PathVariable Character status) {
        return shedService.findByStatus(status);
    }

    // Inactivar un shed (cambiar su estado a 'I')
    @PatchMapping("/{id}/inactivate")
    public Mono<Shed> inactivateShed(@PathVariable Long id) {
        return shedService.inactivate(id);
    }

    // Activar un shed (cambiar su estado a 'A')
    @PatchMapping("/{id}/activate")
    public Mono<Shed> activateShed(@PathVariable Long id) {
        return shedService.activate(id);
    }
}
