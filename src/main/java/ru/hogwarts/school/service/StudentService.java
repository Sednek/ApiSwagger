package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;


@Service
public class StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    private long id = 0L;

    //CRUD
    public Student createStudent(Student student) {
        this.students.put(id++, student);
        return student;
    }

    public Student readStudent(long id) {
        return this.students.get(id);
    }

    public Student updateStudent(Student student) {
        this.students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return this.students.remove(id);
    }

    public Map<Long, Student> getAllStudents(){
        return this.students;
    }

    public Map<Long, Student> getStudentsByAge(int age){
        Map<Long, Student> resp = new HashMap<>();
        students.entrySet()
                .stream().
                filter(entry -> entry.getValue().getAge() == age)
                .forEach(entry -> resp.put(entry.getKey(), entry.getValue()));
        return resp;
    }
}
