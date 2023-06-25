package org.fasttrackit.finalProject.controller;

import lombok.AllArgsConstructor;
import org.fasttrackit.finalProject.model.Person;
import org.fasttrackit.finalProject.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;
    @GetMapping
    public List<Person> getAll(){
        return personService.getAll();
    }
}
