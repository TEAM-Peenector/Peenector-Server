package com.deploy.peenector.controller.auth.dto.response;

import com.deploy.peenector.domain.student.Student;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class SignupResponseDto {
    private Long id;

    public SignupResponseDto(Student entity) {
        this.id = entity.getId();
    }
}
