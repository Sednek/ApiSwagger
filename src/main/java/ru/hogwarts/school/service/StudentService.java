package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //CRUD
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student readStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByAge(int age){
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getAge() == age).toList();
    }

    public List<Student> getStudentBetweenAge(int ageMin, int ageMax){
        return studentRepository.findAllStudentByAgeBetween(ageMin, ageMax);
    }
}
