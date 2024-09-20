package com.example.demo.Controller;


import com.example.demo.AuthenticationResponse;
import com.example.demo.DTO.ApiResponse;
import com.example.demo.DTO.LoginRequest;
import com.example.demo.Service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> authenticateUser(@RequestBody LoginRequest loginRequest,
                                                                                HttpServletRequest request) throws Exception {
        try {
            // Xác thực người dùng
            var result = authService.authenticate(loginRequest);

            // Trả về phản hồi thành công
            return ResponseEntity.ok(
                    ApiResponse.<AuthenticationResponse>builder()
                            .data(result)
                            .message("Login successful")
                            .path(request.getRequestURI())  // Lấy đường dẫn từ request
                            .timestamp(LocalDateTime.now())
                            .build()
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(
                            ApiResponse.<AuthenticationResponse>builder()
                                    .message("Unauthorized - Invalid credentials")
                                    .path(request.getRequestURI())  // Lấy đường dẫn từ request
                                    .timestamp(LocalDateTime.now())
                                    .build()
                    );
        }
    }
}


