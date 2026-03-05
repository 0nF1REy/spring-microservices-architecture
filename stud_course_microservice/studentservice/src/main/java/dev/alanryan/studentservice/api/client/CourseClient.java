package dev.alanryan.studentservice.api.client;

import dev.alanryan.studentservice.api.dto.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="course-service", url="http://localhost:8080")
public interface CourseClient {
    @GetMapping("/courses/{id}")
    Course getCourseById(@PathVariable("id") Long id);
}
