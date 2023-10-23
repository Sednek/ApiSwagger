package ru.hogwarts.school.model;


import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Student() {

    }
}
