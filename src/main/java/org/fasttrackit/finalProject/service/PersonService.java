package org.fasttrackit.finalProject.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.fasttrackit.finalProject.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    @PostConstruct
    public void init(){
        personRepository.save(new Person("John", 95, 175));
        personRepository.save(new Person("Pitt", 72, 185));
        personRepository.save(new Person("Fred", 84, 167));
        personRepository.save(new Person("Bruno", 105, 192));

    }
    public List<Person> getAll(){
        return personRepository.findAll();
    }
    public double bodyMassIndex(){
    Person person = (Person) personRepository.findAll();

        return person.getWeight()/(person.getHeight()*person.getHeight());
    }
}
