package dev.alanryan.courseservice.api.controller;

import dev.alanryan.courseservice.api.entity.Course;
import dev.alanryan.courseservice.api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseRepository courseRepository;

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("O curso com o ID = [" + id + "] não foi encontrado!"));
    }
}
