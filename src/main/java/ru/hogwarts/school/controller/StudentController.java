package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //CRUD
    @GetMapping
    public Map<Long, Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    public Student createStudent(Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable long id) {
        return studentService.readStudent(id);
    }

    @PutMapping("/update")
    public Student updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public Student deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("filter/{age}")
    public Map<Long, Student> getStudentsByAge(@PathVariable int age){
        return studentService.getStudentsByAge(age);
    }
}
