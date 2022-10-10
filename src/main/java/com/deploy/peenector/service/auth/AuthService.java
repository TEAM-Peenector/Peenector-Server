package com.deploy.peenector.service.auth;

import com.deploy.peenector.common.exception.ErrorCode;
import com.deploy.peenector.common.exception.model.ValidationException;
import com.deploy.peenector.controller.auth.dto.request.LoginRequestDto;
import com.deploy.peenector.controller.auth.dto.request.SignupRequestDto;
import com.deploy.peenector.controller.auth.dto.response.LoginResponseDto;
import com.deploy.peenector.controller.auth.dto.response.SignupResponseDto;
import com.deploy.peenector.domain.student.Student;
import com.deploy.peenector.domain.student.StudentRepository;
import com.deploy.peenector.domain.team.Team;
import com.deploy.peenector.domain.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AuthService {

    private final StudentRepository studentRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public SignupResponseDto save(SignupRequestDto signupDto) {
        Student newStudent = studentRepository.save(signupDto.toEntity());
        Long teamId = newStudent.getId() / 10 + 1;
        if (newStudent.getId() % 10 == 0) {
            teamId = newStudent.getId() / 10;
        }
        Long finalTeamId = teamId;
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("해당 팀이 없습니다. Id = " + finalTeamId));

        newStudent.setTeam(team);
        studentRepository.save(newStudent);

        return new SignupResponseDto(newStudent);
    }

    public LoginResponseDto findBySchoolNumber(LoginRequestDto loginDto) {
        Student student = studentRepository.findBySchoolNumber(loginDto.getSchoolNumber());

        return new LoginResponseDto(student);
    }
}
