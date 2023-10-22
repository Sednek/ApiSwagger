package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {

    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long id = 0L;

    //CRUD
    public Faculty createFaculty(Faculty faculty) {
        this.faculties.put(id++, faculty);
        return faculty;
    }

    public Faculty readFaculty(long id) {
        return this.faculties.get(id);
    }

    public Faculty updateFaculty(Faculty faculty) {
        this.faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return this.faculties.remove(id);
    }

    public Map<Long, Faculty> getAllFaculties(){
        return this.faculties;
    }

    public Map<Long, Faculty> getFacultiesByColor(String color){
        Map<Long, Faculty> resp = new HashMap<>();
        faculties.entrySet()
                .stream().
                filter(entry -> entry.getValue().getColor().equals(color))
                .forEach(entry -> resp.put(entry.getKey(), entry.getValue()));
        return resp;
    }
}
