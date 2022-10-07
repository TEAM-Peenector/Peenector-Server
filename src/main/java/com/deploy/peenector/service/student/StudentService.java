package com.deploy.peenector.service.student;

import com.deploy.peenector.common.dto.ApiResponse;
import com.deploy.peenector.controller.student.dto.response.StudentResponseDto;
import com.deploy.peenector.controller.team.dto.response.TeamResponseDto;
import com.deploy.peenector.domain.student.Student;
import com.deploy.peenector.domain.student.StudentRepository;
import com.deploy.peenector.domain.team.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponseDto findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. Id = " + id));

        return new StudentResponseDto(student);
    }

    public List<TeamResponseDto> findTeamByTeamId(Long id) {
        List<TeamResponseDto> teamList = new ArrayList<>();
        List<Student> team = studentRepository.findAllByTeamId(id);

        for (Student one : team) {
            TeamResponseDto student = new TeamResponseDto(one);
            teamList.add(student);
        }


        return teamList;
    }
}
