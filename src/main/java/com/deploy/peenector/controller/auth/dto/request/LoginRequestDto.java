package com.deploy.peenector.controller.auth.dto.request;

import com.deploy.peenector.domain.student.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    private String schoolNumber;

    private String password;

    @Builder
    public LoginRequestDto(String schoolNumber, String password) {
        this.schoolNumber = schoolNumber;
        this.password = password;
    }

    public Student toEntity() {
        return Student.builder()
                .schoolNumber(schoolNumber)
                .password(password)
                .build();
    }
}
