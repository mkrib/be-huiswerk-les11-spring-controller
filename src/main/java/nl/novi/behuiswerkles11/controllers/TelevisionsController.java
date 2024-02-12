package nl.novi.behuiswerkles11.controllers;

import nl.novi.behuiswerkles11.models.Television;
import nl.novi.behuiswerkles11.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {
    private final TelevisionRepository televisionRepository;

    public TelevisionsController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Television>> getTelevisions() {
        return ResponseEntity.ok(televisionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Television>> getOneTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionRepository.findById(id));
    }

    // Omdat we hier iets posten in plaats van aanvragen, hebben we geen body in onze return. Vandaar dat er <void> staat na het definieren van de ResponseEntity.
    @PostMapping()
    public ResponseEntity<Void> addTelevision(@RequestBody Television television) {
        televisionRepository.save(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        televisionRepository.saveAndFlush(television);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision (@PathVariable Long id) {
        televisionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}