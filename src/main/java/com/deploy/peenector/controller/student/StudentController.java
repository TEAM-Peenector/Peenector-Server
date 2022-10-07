package com.deploy.peenector.controller.student;

import com.deploy.peenector.common.dto.ApiResponse;
import com.deploy.peenector.common.exception.SuccessCode;
import com.deploy.peenector.controller.student.dto.response.StudentResponseDto;
import com.deploy.peenector.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/v1/student/{id}")
    public ApiResponse<StudentResponseDto> findById(@PathVariable Long id) {
        final StudentResponseDto student = studentService.findById(id);

        return ApiResponse.success(SuccessCode.GET_STUDENT_SUCCESS, student);
    }
}
