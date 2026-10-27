package com.example.studentapi.controller;

import com.example.studentapi.model.Student;
import com.example.studentapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET /api/students  or  /api/students?course=Java
    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) String course) {
        return (course == null) ? service.getAll() : service.getByCourse(course);
    }

    // GET /api/students/1
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST /api/students
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@Valid @RequestBody Student student) {
        return service.create(student);
    }

    // PUT /api/students/1
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        return service.update(id, student);
    }

    // DELETE /api/students/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        service.delete(id);
    }
}
