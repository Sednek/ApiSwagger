package ru.hogwarts.school.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int age;

    public Student() {

    }
}
