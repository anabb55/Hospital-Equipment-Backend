package com.ISAproject.hospitalequipment.config;

import com.ISAproject.hospitalequipment.security.RestAuthenticationEntryPoint;
import com.ISAproject.hospitalequipment.security.TokenAuthenticationFilter;
import com.ISAproject.hospitalequipment.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ISAproject.hospitalequipment.util.TokenUtils;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
//kako bismo mogli da napisemo anotacije za autorizaciju
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    @Bean
    public MyUserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());

        return  authenticationProvider;
    }

    @Autowired
    private TokenUtils tokenUtils;


    //radi autentifikaciju korisnika za nas
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.exceptionHandling(configurer -> configurer.authenticationEntryPoint(restAuthenticationEntryPoint));
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("api/authentication/**").permitAll()
                        .requestMatchers("api/companyProfile/**").permitAll()
                        .requestMatchers("api/registeredUsers/**").permitAll()
                        .requestMatchers("api/appointments/**").permitAll()
                        .requestMatchers("api/loyaltyProgram/**").hasRole("SYSTEM_ADMIN")
                        .requestMatchers("api/companyAdministrators/**").permitAll()
                        .requestMatchers("api/systemAdmins/**").permitAll()
                        .requestMatchers("api/addresses/**").permitAll()
                        .requestMatchers("api/users/**").permitAll()
                        .requestMatchers("api/reservation/**").permitAll()
                        .requestMatchers("api/equipmentStocks/**").permitAll()
                        .requestMatchers("api/equipments/**").permitAll()
                        .requestMatchers("api/appointments/update/{id}").hasRole("REGISTERED_USER")
                        .requestMatchers("mywebsockets").permitAll()
                        .requestMatchers("api/appointments/update/**").hasRole("REGISTERED_USER")
                        .requestMatchers("api/producer/**").permitAll()


                .anyRequest().authenticated())

                .cors(withDefaults())
                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils,  userDetailsService()), BasicAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable());



        http.authenticationProvider(authenticationProvider());

        return http.build();
    }


    //u kojim metodama se ignorise autentifikacija
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        return (web) -> web.ignoring().requestMatchers(HttpMethod.POST, "api/authentication/login")

                .requestMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "favicon.ico",
                        "/*/*.html", "/*/*.css", "/*/*.js")
                .requestMatchers("/v2/api-docs",
                        "/configuration/**",
                        "/swagger*/**",
                        "/webjars/**");


    }

}
