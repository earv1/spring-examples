package com.learning.demo.rest;

import com.learning.demo.model.Criminal;
import com.learning.demo.repository.CriminalsJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/database/api")
public class CriminalsController {


    @Autowired
    CriminalsJDBCRepository criminalsJdbcRepository;

    @GetMapping("/Criminals/name/{name}")
    public Criminal getCriminalsByName(@PathVariable(value = "name") String CriminalName) {
        return criminalsJdbcRepository.findCriminalByNameContains(CriminalName).get(0);
    }
}
