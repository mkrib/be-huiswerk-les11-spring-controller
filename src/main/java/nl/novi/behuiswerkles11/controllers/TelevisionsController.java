package nl.novi.behuiswerkles11.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {
    @GetMapping()
    public ResponseEntity<String> getTelevisions() {
//        return ResponseEntity.ok("televisions");
        return new ResponseEntity<>("all televisions", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOneTelevision(@PathVariable Integer id) {
        return ResponseEntity.ok("televisionId: " + id);
    }

    // Omdat we hier iets posten in plaats van aanvragen, hebben we geen body in onze return. Vandaar dat er <void> staat na het definieren van de ResponseEntity.
    @PostMapping()
    public ResponseEntity<Void> addTelevision(@RequestBody String television) {
        System.out.println(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) {
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision (@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

}