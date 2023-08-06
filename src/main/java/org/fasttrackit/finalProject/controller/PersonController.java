package org.fasttrackit.finalProject.controller;

import lombok.AllArgsConstructor;
import org.fasttrackit.finalProject.model.Person;
import org.fasttrackit.finalProject.service.PersonService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("{id}")
    public Person getById(@PathVariable long id) {
        return personService.getById(id);
    }
    @PostMapping
    public Person addNewPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
    @DeleteMapping("{id}")
    public Person deleteById(@PathVariable long id){
        return personService.delete(id);
    }
    @PutMapping("{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable long id){
        return personService.update(person,id);
    }

}