package org.fasttrackit.finalProject.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.fasttrackit.finalProject.exception.ResourceNotFoundException;
import org.fasttrackit.finalProject.model.BMITypes;
import org.fasttrackit.finalProject.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonReader personReader;
    private final BMITypesRepository bmiTypesRepository;
    @PostConstruct
    public void init(){
        System.out.println("post construct in PS");
        List<Person> people = personReader.readPeople();
        personRepository.saveAll(people);


    }


    public List<Person> getAll(){
        return personRepository.findAll();

    }
    public Person getById(long id){
        return personRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("person not found", id));
    }
    public Person addPerson(Person person){
         personRepository.save(Person.builder()
                .id(person.getId())
                .name(person.getName())
                .weight(person.getWeight())
                .height(person.getHeight())
                 .age(person.getAge())
                 .bodyMassIndex(new BMITypes(null,(person.getWeight()/(person.getHeight()*person.getHeight())*10000)))
                .build());
        return person;
    }
    public Person delete(long id){
        Person person = getById(id);
        personRepository.delete(person);
        return person;
    }
    public Person update (Person person, long id){
        Person existingPerson = delete(id);
        return addPerson(Person.builder()
                .id(existingPerson.getId())
                .name(existingPerson.getName())
                .weight(person.getWeight())
                .height(person.getHeight())
                .age(person.getAge())
                .bodyMassIndex(new BMITypes(null,(person.getWeight()/(person.getHeight()*person.getHeight())*10000)))
                .build());

    }


}

