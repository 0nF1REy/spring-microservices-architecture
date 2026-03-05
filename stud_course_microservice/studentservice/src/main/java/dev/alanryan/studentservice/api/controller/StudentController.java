package dev.alanryan.studentservice.api.controller;

import dev.alanryan.studentservice.api.client.CourseClient;
import dev.alanryan.studentservice.api.dto.Course;
import dev.alanryan.studentservice.api.entity.Student;
import dev.alanryan.studentservice.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;
    private final CourseClient courseClient;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Estudante com ID [" + id + "] não encontrado."));
    }

    @GetMapping("/{id}/course")
    public Map<String, Object> getStudentWithCourse(@PathVariable Long id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Estudante com ID [" + id + "] não encontrado."));

        Course course = courseClient.getCourseById(student.getCid());

        Map<String, Object> response = new HashMap<>();
        response.put("student", student);
        response.put("course", course);

        return response;
    }
}
