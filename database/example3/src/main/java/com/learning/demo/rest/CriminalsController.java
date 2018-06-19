package com.learning.demo.rest;

import com.learning.demo.exception.ResourceNotFoundException;
import com.learning.demo.model.Criminal;
import com.learning.demo.repository.CriminalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/database/api")
public class CriminalsController {

    @Autowired
    CriminalsRepository criminalsRepository;

    // Get All Criminals
    @GetMapping("/Criminals")
    public List<Criminal> getAllCriminalss() {
        return criminalsRepository.findAll();
    }

    // Create a new Criminal
    @PostMapping("/Criminal")
    public Criminal createCriminals(@Valid @RequestBody Criminal Criminal) {
        return criminalsRepository.save(Criminal);
    }

    // Get a Single Criminal
    @GetMapping("/Criminals/{id}")
    public Criminal getCriminalsById(@PathVariable(value = "id") Long CriminalId) {
        return criminalsRepository.findById(CriminalId)
                .orElseThrow(() -> new ResourceNotFoundException("Criminals", "id", CriminalId));
    }

    // Get a Single Criminal
    @GetMapping("/Criminals/name/{name}")
    public Criminal getCriminalsByName(@PathVariable(value = "name") String CriminalName) {
        return criminalsRepository.findCriminalByNameContains(CriminalName).get(0);
    }

    // Update a Criminal
    @PutMapping("/Criminals/{id}")
    public Criminal updateCriminals(@PathVariable(value = "id") Long CriminalId,
                           @Valid @RequestBody Criminal CriminalsDetails) {

        Criminal Criminals = criminalsRepository.findById(CriminalId)
                .orElseThrow(() -> new ResourceNotFoundException("Criminals", "id", CriminalId));

        Criminals.setName(CriminalsDetails.getName());
        Criminals.setCity(CriminalsDetails.getCity());

        return criminalsRepository.save(Criminals);
    }

    // Delete a Criminal
    @DeleteMapping("/Criminals/{id}")
    public ResponseEntity<?> deleteCriminals(@PathVariable(value = "id") Long CriminalId) {
        Criminal Criminals = criminalsRepository.findById(CriminalId)
                .orElseThrow(() -> new ResourceNotFoundException("Criminals", "id", CriminalId));

        criminalsRepository.delete(Criminals);

        return ResponseEntity.ok().build();
    }
}
