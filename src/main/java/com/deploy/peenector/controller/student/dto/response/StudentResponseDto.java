package com.deploy.peenector.controller.student.dto.response;

import com.deploy.peenector.domain.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class StudentResponseDto {

    private String teamName;

    private String studentName;

    private String schoolNumber;

    private String contact;

    public StudentResponseDto(Student entity) {
        this.teamName = entity.getTeam().getName();
        this.studentName = entity.getName();
        this.schoolNumber = entity.getSchoolNumber();
        this.contact = entity.getContact();
    }
}
