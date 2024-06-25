package org.skhuton.skhudebug.config;


import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.member.handler.CustomAuthenticationFailureHandler;
import org.skhuton.skhudebug.member.handler.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends Exception {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        HeaderWriterLogoutHandler clearSiteData = new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.COOKIES));
        http
                .cors(c -> {
                            CorsConfigurationSource source = request -> {
                                var cors = new CorsConfiguration();
                                //허용할 origin
                                cors.addAllowedOriginPattern("*");
                                //허용할 method(CRUD)
                                cors.setAllowedMethods(List.of("*"));
                                //허용할 헤더
                                cors.setAllowedHeaders(List.of("*"));
                                cors.setAllowCredentials(true);
                                cors.setMaxAge(3600L);
                                return cors;
                            };
                            c.configurationSource(source);
                        }
                )
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/**").permitAll()
                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//필요 시 세션 생성
                        .maximumSessions(5) // 동시 접속 가능 세션 오직 1
                        .maxSessionsPreventsLogin(false) //로그인 시도 시 현재 접속시도자 인증 실패
                        .sessionRegistry(sessionRegistry())
                )
                //form login 설정
                .formLogin((formLogin) ->
                        formLogin //Postman으로 테스트 시 raw가 아닌 form-data로 해야 한다.
                                .usernameParameter("loginId")
                                .passwordParameter("password")
                                .loginProcessingUrl("/user/login") //로그인 경로
                                .successHandler(customAuthenticationSuccessHandler) //로그인 성공 시 핸들러
                                .failureHandler(customAuthenticationFailureHandler)) //로그인 실패 시 핸들러
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)) //로그아웃 성공 시 핸들러
                        .addLogoutHandler(clearSiteData) //로그아웃 시 캐시 삭제
                        .invalidateHttpSession(true)); // 로그아웃 시 인증정보 삭제 및 세션 무효화

        return http.build();
    }

    @Bean
    //스프링 시큐리티의 인증을 담당, 사용자 인증 시 UserService와 PasswordEncoder 사용
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}
