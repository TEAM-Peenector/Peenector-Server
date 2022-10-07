package com.deploy.peenector.controller.team;

import com.deploy.peenector.common.dto.ApiResponse;
import com.deploy.peenector.common.exception.SuccessCode;
import com.deploy.peenector.controller.team.dto.response.TeamResponseDto;
import com.deploy.peenector.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeamController {

    private final StudentService studentService;

    @GetMapping("/v1/team/{teamId}")
    public ApiResponse<List<TeamResponseDto>> findById(@PathVariable Long teamId) {
        List<TeamResponseDto> team = studentService.findTeamByTeamId(teamId);

        return ApiResponse.success(SuccessCode.GET_TEAM_SUCCESS, team);
    }

    @GetMapping("/v1/team/{teamId}/mission")
    public ApiResponse<Long> findMissionByTeamId(@PathVariable Long teamId) {
        Long missionId = teamId / 10 + 1;
        if (teamId % 10 == 0) {
            missionId = teamId / 10;
        }

        return ApiResponse.success(SuccessCode.GET_MISSION_SUCCESS, missionId);
    }
}
