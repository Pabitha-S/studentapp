package com.example.studentapi.service;

import com.example.studentapi.exception.DuplicateEmailException;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.model.Student;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public List<Student> getByCourse(String course) {
        return repository.findByCourse(course);
    }

    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student create(Student student) {
        if (repository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException(student.getEmail());
        }
        return repository.save(student);
    }

    public Student update(Long id, Student updated) {
        Student existing = getById(id);

        if (repository.existsByEmailAndIdNot(updated.getEmail(), id)) {
            throw new DuplicateEmailException(updated.getEmail());
        }

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setCourse(updated.getCourse());
        return repository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }
}