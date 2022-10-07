package com.deploy.peenector.controller.team.dto.response;

import com.deploy.peenector.domain.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class TeamResponseDto {

    private String major;

    private String studentName;

    public TeamResponseDto(Student entity) {
        System.out.println(entity.getSchoolNumber().substring(4, 6).equals("11"));
        if (entity.getSchoolNumber().substring(4, 6).equals("11")) {
            this.major = "인문융합자율학부";
        }
        if (entity.getSchoolNumber().substring(4, 6).equals("12")) {
            this.major = "사회융합자율학부";
        }
        if (entity.getSchoolNumber().substring(4, 6).equals("13")) {
            this.major = "미디어컨텐츠융합자율학부";
        }
        if (entity.getSchoolNumber().substring(4, 6).equals("14")) {
            this.major = "IT 융합자율학부";
        }

        this.studentName = entity.getName();
    }
}
