package com.hungdev.firstproject.config;

import com.hungdev.firstproject.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfig {
//
//    private JwtAuthenticationFilter jwtAuthFilter;
//    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,AuthenticationProvider authenticationProvider, // <-- Thêm tham số
                                                   JwtAuthenticationFilter jwtAuthFilter) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF
                .authorizeHttpRequests(auth -> auth
                        // Cho phép truy cập public vào API đăng ký/đăng nhập
                        .requestMatchers("/api/user/**").permitAll()

                        .requestMatchers("/api/content/**").permitAll()

                        .requestMatchers("/api/doctors/**").permitAll()

                        .requestMatchers("/api/notifications/**").permitAll()

                        .requestMatchers("/api/medicalprofile/**").permitAll()

                        .requestMatchers("/api/blogs/**").permitAll()

                        .requestMatchers("/api/userexercises/**").permitAll()

                        .requestMatchers("/ws/**", "/ws-raw/**", "/app/**", "/topic/**", "/queue/**").permitAll()

                        // Tất cả các request khác đều cần xác thực
                        .anyRequest().authenticated()
                )
                // Cấu hình session management là STATELESS (không dùng session)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Cung cấp AuthenticationProvider
                .authenticationProvider(authenticationProvider)
                // Thêm bộ lọc JWT vào trước bộ lọc UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Bean PasswordEncoder để băm mật khẩu
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean AuthenticationProvider
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, // <-- Thêm tham số
                                                         PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Bean AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}