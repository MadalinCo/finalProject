package org.fasttrackit.finalProject.service;

import org.fasttrackit.finalProject.model.BMITypes;
import org.fasttrackit.finalProject.model.Person;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.valueOf;


@Component

public class PersonReader {


    public List<Person> readPeople(){
        List<Person> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("C:\\won11\\finalProject\\src\\main\\resources\\people.txt"));
            long id = 1;
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                people.add(fromLine(line, id++));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return people;
    }
    private Person fromLine(String line, long id){
        System.out.println(line);
        String[] tokens = line.split("\\|");
        Person.PersonBuilder personBuilder = Person.builder()
                .id(id)
                .name(tokens[0])
                .weight(Double.parseDouble(tokens[1]))
                .height(Double.parseDouble(tokens[2]))
                .age(Integer.parseInt(tokens[3]))
                .bodyMassIndex(new BMITypes(null, (valueOf(valueOf(tokens[1])/(valueOf(tokens[2])*valueOf(tokens[2])))*10000)));


        return  personBuilder.build();
    }


    private String BMIFeedback(double bodyMassIndex){
        if(bodyMassIndex<18.5){
            return "Underweight";
        }
        else if(24.9>bodyMassIndex && bodyMassIndex>18.5){
            return "Healthy Weight";
        } else if (29.9>bodyMassIndex && bodyMassIndex>25) {
            return "Overweight";

        } else if (bodyMassIndex>=30) {
            return "Obesity";

        }
        else return "You introduced wrong measurements!";

    }



}


