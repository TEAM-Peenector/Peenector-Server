package com.deploy.peenector.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findBySchoolNumber(String SchoolNumber);
    List<Student> findAllByTeamId(Long teamId);
}
