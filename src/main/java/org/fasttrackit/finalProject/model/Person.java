package org.fasttrackit.finalProject.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Person {
    @Id
    @GeneratedValue
    private  long id;
    @Column
    private  String name;
    @Column
    private  double weight;
    @Column
    private  double height;
   @Column
    private int age;
    @OneToOne(cascade=CascadeType.ALL)
    private BMITypes bodyMassIndex;
}
