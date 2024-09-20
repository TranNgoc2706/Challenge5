package com.example.demo.DTO;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T > {
    private boolean success;
    private T data;
    private String message;
    private String path; 
    private LocalDateTime timestamp;
}
