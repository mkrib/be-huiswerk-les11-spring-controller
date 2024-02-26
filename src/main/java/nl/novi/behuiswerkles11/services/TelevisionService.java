package nl.novi.behuiswerkles11.services;

import nl.novi.behuiswerkles11.dtos.TelevisionRequestDto;
import nl.novi.behuiswerkles11.exceptions.RecordNotFoundException;
import nl.novi.behuiswerkles11.models.Television;
import nl.novi.behuiswerkles11.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    //    Functie voor het ophalen van alle tv's
    public List<Television> getTelevisions() {
        return televisionRepository.findAll();
    }

    //    Functie voor het ophalen van 1 tv
    public Television getTelevision(Long id) {
        return televisionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Television not found"));
    }

    //    POST Functie voor het toevoegen van 1 tv
    public Television addTelevision(Television television) {
        televisionRepository.save(television);
        return television;
    }

    //    PUT Functie voor het aanpassen van 1 tv
//    public Television updateTelevision(Long id, Television television) {
//        Optional<Television> televisionOptional = televisionRepository.findById(id);
//        if (televisionOptional.isPresent()) {
//            televisionOptional.get();
//        }
//        return television;
//    }

    //    Functie voor het verwijderen van 1 tv
    public void deleteTelevisionById(@RequestBody Long id) {
        televisionRepository.deleteById(id);
    }
}


