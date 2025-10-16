package animus.messaging.MessagingApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConf  {
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Allow all requests without authentication
                )
                .formLogin(login -> login.disable()) // Disable login form
                .httpBasic(basic -> basic.disable()); // Disable basic auth

        return http.build();
    }
//    @Bean
//    UserDetailsService authentication() {
//        UserDetails peter = User.builder()
//                .username("mohanad")
//                .password(passwordEncoder.encode("ppassword")) .roles("USER")
//                .build();
//
//    UserDetails jodie = User.builder()
//            .username("jodie")
//            .password(passwordEncoder.encode("jpassword")) .roles("USER", "ADMIN")
//            .build();
//    System.out.println(" >>> Peter's password: " + peter.getPassword()); System.out.println(" >>> Jodie's password: " + jodie.getPassword());
//    return new InMemoryUserDetailsManager(peter, jodie);
//}



}
