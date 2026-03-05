package dev.alanryan.studentservice.api.repository;

import dev.alanryan.studentservice.api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
