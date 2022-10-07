package com.deploy.peenector.controller.auth.dto.request;

import com.deploy.peenector.domain.student.Student;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupRequestDto {

    private String schoolNumber;

    private String name;

    private String password;

    private String passwordCheck;

    private String contact;

    private String email;

    @Builder
    public SignupRequestDto(String schoolNumber, String name, String password, String passwordCheck, String contact, String email) {
        this.schoolNumber = schoolNumber;
        this.name = name;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.contact = contact;
        this.email = email;
    }

    public Student toEntity() {
        return Student.builder()
                .schoolNumber(schoolNumber)
                .name(name)
                .password(password)
                .contact(contact)
                .email(email)
                .build();
    }
}
