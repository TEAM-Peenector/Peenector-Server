package com.deploy.peenector.service.auth;

import com.deploy.peenector.common.exception.ErrorCode;
import com.deploy.peenector.common.exception.model.ValidationException;
import com.deploy.peenector.controller.auth.dto.request.LoginRequestDto;
import com.deploy.peenector.controller.auth.dto.request.SignupRequestDto;
import com.deploy.peenector.controller.auth.dto.response.LoginResponseDto;
import com.deploy.peenector.controller.auth.dto.response.SignupResponseDto;
import com.deploy.peenector.domain.student.Student;
import com.deploy.peenector.domain.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AuthService {

    private final StudentRepository studentRepository;

    @Transactional
    public SignupResponseDto save(SignupRequestDto signupDto) {
        Student newStudent = studentRepository.save(signupDto.toEntity());

        return new SignupResponseDto(newStudent);
    }

    public LoginResponseDto findBySchoolNumber(LoginRequestDto loginDto) {
        Student student = studentRepository.findBySchoolNumber(loginDto.getSchoolNumber());

        return new LoginResponseDto(student);
    }
}
