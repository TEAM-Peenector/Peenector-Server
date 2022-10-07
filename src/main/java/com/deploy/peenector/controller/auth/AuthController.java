package com.deploy.peenector.controller.auth;

import com.deploy.peenector.common.dto.ApiResponse;
import com.deploy.peenector.common.exception.SuccessCode;
import com.deploy.peenector.controller.auth.dto.request.LoginRequestDto;
import com.deploy.peenector.controller.auth.dto.request.SignupRequestDto;
import com.deploy.peenector.controller.auth.dto.response.LoginResponseDto;
import com.deploy.peenector.controller.auth.dto.response.SignupResponseDto;
import com.deploy.peenector.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/v1/signup")
    public ApiResponse<SignupResponseDto> signup(@RequestBody final SignupRequestDto request) {
        final SignupResponseDto newUser = authService.save(request);

        return ApiResponse.success(SuccessCode.SIGNUP_SUCCESS, newUser);
    }

    @PostMapping("v1/login")
    public ApiResponse<LoginResponseDto> login(@RequestBody final LoginRequestDto requestDto) {
        final LoginResponseDto user = authService.findBySchoolNumber(requestDto);

        return ApiResponse.success(SuccessCode.LOGIN_SUCCESS, user);
    }
}
