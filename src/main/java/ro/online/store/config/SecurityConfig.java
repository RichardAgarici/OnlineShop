package ro.online.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("profile1")
public class SecurityConfig {

    private static final String ROL_USER = "USER";
    private static final String ROL_ADMIN = "ADMIN";
    private static final String ROL_POWER_USER = "POWER_USER";
    @Bean
    @Primary
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder().encode("1234"))
                .roles(ROL_USER)
                .build());

        manager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder().encode("1234"))
                .roles(ROL_ADMIN)
                .build());

        manager.createUser(User.withUsername("powerUser")
                .password(bCryptPasswordEncoder().encode("1234"))
                .roles(ROL_POWER_USER, ROL_USER, ROL_ADMIN)
                .build());

        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> {
            //category role
            auth.requestMatchers("/api/category/create").hasRole(ROL_ADMIN);
            auth.requestMatchers("/api/category/{id}").hasRole(ROL_USER);
            auth.requestMatchers("/api/category/").hasRole(ROL_USER);
            auth.requestMatchers("/api/category").hasRole(ROL_POWER_USER);
            //manufacturer role
            auth.requestMatchers("/api/manufacturer/create").hasRole(ROL_USER);
            auth.requestMatchers("/api/manufacturer/{id}").hasRole(ROL_USER);
            auth.requestMatchers("/api/manufacturer/find_all").hasRole(ROL_USER);

            //product role
            auth.requestMatchers("/api/product/create").hasRole(ROL_USER);
            auth.requestMatchers("/api/product/{id}").hasRole(ROL_USER);
            auth.requestMatchers("/api/product/find_all").hasRole(ROL_USER);


        }).httpBasic();

        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .and()
                .cors()
                .disable()
                .authorizeHttpRequests();

        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        return (web) -> web
                .ignoring()
                .requestMatchers("/images/**", "/js/**", "/webjars/**");
    }
}
