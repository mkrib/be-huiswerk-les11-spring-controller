package nl.novi.behuiswerkles11.controllers;

import jakarta.validation.Valid;
import nl.novi.behuiswerkles11.dtos.TelevisionRequestDto;
import nl.novi.behuiswerkles11.dtos.TelevisionDto;
import nl.novi.behuiswerkles11.mappers.TelevisionModelMapper;
import nl.novi.behuiswerkles11.models.Television;
import nl.novi.behuiswerkles11.services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {
    private final TelevisionService televisionService;
    private final TelevisionModelMapper televisionModelMapper;

    public TelevisionsController(TelevisionService televisionService, TelevisionModelMapper televisionModelMapper) {
        this.televisionService = televisionService;
        this.televisionModelMapper = televisionModelMapper;
    }

    @GetMapping()
    public ResponseEntity<List<TelevisionDto>> getTelevisions() {
        List<Television> televisions = televisionService.getTelevisions();
        List<TelevisionDto> televisionDtos = televisionModelMapper.translateToDtos(televisions);

        return ResponseEntity.ok(televisionDtos);
    }

    //    Request mapping voor het ophalen van 1 tv op basis van het id
    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

    // Omdat we hier iets posten in plaats van aanvragen, hebben we geen body in onze return. Vandaar dat er <void> staat na het definieren van de ResponseEntity.
//    Request mapping voor het toevoegen van 1 tv
    @PostMapping()
    public ResponseEntity<TelevisionDto> addTelevision(@Valid @RequestBody TelevisionRequestDto television) {
        Television savedTelevision = televisionService.addTelevision(televisionModelMapper.createTelevision(television));
        return ResponseEntity.status(HttpStatus.CREATED).body(televisionModelMapper.translateToDto(savedTelevision));
    }

//    Request mapping voor het aanpassen van 1 tv op basis van het id
//    @PutMapping("/{id}")
//    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionRequestDto televisionRequestDto) {
//        TelevisionDto dto = televisionService.updateTelevision(id, televisionRequestDto);
//
//        return ResponseEntity.noContent().build(dto);
//    }

    //    Request mapping voor het verwijderen van 1 tv op basis van het id
    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevisionById(id);
        return ResponseEntity.noContent().build();
    }

}