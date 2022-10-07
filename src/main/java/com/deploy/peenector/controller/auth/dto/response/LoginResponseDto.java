package com.deploy.peenector.controller.auth.dto.response;

import com.deploy.peenector.domain.student.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {

    private String schoolNumber;

    private Long teamNumber;

    @Builder
    public LoginResponseDto(Student entity) {
        this.schoolNumber = entity.getSchoolNumber();
        this.teamNumber = entity.getTeam().getId();
    }
}
