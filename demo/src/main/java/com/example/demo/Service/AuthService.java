package com.example.demo.Service;


import com.example.demo.AuthenticationResponse;
import com.example.demo.DTO.LoginRequest;
import com.example.demo.User;
import com.example.demo.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService {
    UserRepository userRepository;

    @NonFinal
    protected  static  final  String SIGNER_KEY ="3f5cZg4zM8j9X8Q6T1B2A7Y9bJ0K4P6v7Z3E5R0X8Q1L6N5J8M2P7C3T9F0V6W5Y4K";
   public  AuthenticationResponse authenticate(LoginRequest request){
       PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
       var user = userRepository.findByFullName(request.getFullName())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.FORBIDDEN, "Tên hoặc mật khẩu không đúng!"));

        boolean authenticated = passwordEncoder.matches(request.getPassword(),
                user.getPassword());

        if(!authenticated)
            throw new ApplicationContextException("UNAUTHENTICATED");

        var token = generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();


    }

    private   String generateToken(User user){
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getFullName())
                .issuer("devteria.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("role",user.getRole())
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header,payload);

        try{
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        }catch (JOSEException e){
            log.error("cannot create token");
            throw new RuntimeException(e);
        }

    }
    public String extractUsername(String token) {
        try {
            JWTClaimsSet claims = JWTParser.parse(token).getJWTClaimsSet();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }
    public String extractRole(String token) {
        try {
            JWTClaimsSet claims = JWTParser.parse(token).getJWTClaimsSet();
            return claims.getStringClaim("role");
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            JWTClaimsSet claims = JWTParser.parse(token).getJWTClaimsSet();
            String username = claims.getSubject();
            String role = claims.getStringClaim("role");
            return (username != null && username.equals(userDetails.getUsername()));
        } catch (Exception e) {
            return false;
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

    // Phương thức loadUserByUsername đã được thay đổi để sử dụng getAuthorities
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByFullName(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getFullName(),
                        user.getPassword(),
                        getAuthorities(user) // Sử dụng phương thức getAuthorities
                ))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
