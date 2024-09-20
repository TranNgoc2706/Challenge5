package com.example.demo.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","http://example.com") // Thay đổi theo nguồn gốc của bạn
                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTION") // Chỉ định các phương thức HTTP cụ thể
                .allowedHeaders("*") // Chấp nhận tất cả các tiêu đề
                .allowCredentials(true); // Nếu bạn cần hỗ trợ cookie và các thông tin xác thực
    }
}
