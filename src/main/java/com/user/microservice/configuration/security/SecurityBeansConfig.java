package com.user.microservice.configuration.security;



import com.user.microservice.adapters.driven.jpa.mysql.adapter.AuthenticationAdapter;
import com.user.microservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.user.microservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.user.microservice.configuration.security.jwtconfiguration.JwtService;
import com.user.microservice.domain.api.IAuthenticationServicePort;
import com.user.microservice.domain.api.usecase.AuthenticationUseCase;
import com.user.microservice.domain.spi.IAuthenticationPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityBeansConfig {

    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public IAuthenticationPersistencePort authenticationPersistencePort(AuthenticationManager authenticationManager) {
        return new AuthenticationAdapter(authenticationManager, userRepository, jwtService, userEntityMapper, passwordEncoder());
    }

    @Bean
    public IAuthenticationServicePort authenticationServicePort(AuthenticationManager authenticationManager) {
        return new AuthenticationUseCase(authenticationPersistencePort(authenticationManager));
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
