package nl.novi.behuiswerkles11.controllers;

import jakarta.validation.Valid;
import nl.novi.behuiswerkles11.dtos.RequestTelevisionDTO;
import nl.novi.behuiswerkles11.dtos.ResponseTelevisionDTO;
import nl.novi.behuiswerkles11.models.Television;
import nl.novi.behuiswerkles11.repositories.TelevisionRepository;
import nl.novi.behuiswerkles11.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {
    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping()
    public ResponseEntity<List<ResponseTelevisionDTO>> getTelevisions() {
        return ResponseEntity.ok(televisionService.getTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

    // Omdat we hier iets posten in plaats van aanvragen, hebben we geen body in onze return. Vandaar dat er <void> staat na het definieren van de ResponseEntity.

//    Deze heb ik als enige aangepast naar de service
    @PostMapping()
    public ResponseEntity<Void> addTelevision(@Valid @RequestBody RequestTelevisionDTO television) {
        televisionService.saveTelevision(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        televisionService.saveAndFlush(television);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision (@PathVariable Long id) {
        televisionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}