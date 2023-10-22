package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Map;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    //CRUD
    @GetMapping
    public Map<Long, Faculty> getAllFaculties(){
        return facultyService.getAllFaculties();
    }

    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable long id) {
        return facultyService.readFaculty(id);
    }

    @PostMapping("/add")
    public Faculty createFaculty(Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping("/update")
    public Faculty updateFaculty(Faculty faculty) {
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("/delete/{id}")
    public Faculty deleteFaculty(@PathVariable long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("filter/{color}")
    public Map<Long, Faculty> getStudentsByAge(@PathVariable String color){
        return facultyService.getFacultiesByColor(color);
    }
}
