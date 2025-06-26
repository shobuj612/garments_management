/*
package com.sunshine.sunspring.config;

import com.sunshine.sunspring.security.JwtEntryPoint;
import com.sunshine.sunspring.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final JwtEntryPoint jwtEntryPoint;

    public SecurityConfig(JwtFilter jwtFilter, JwtEntryPoint jwtEntryPoint) {
        this.jwtFilter = jwtFilter;
        this.jwtEntryPoint = jwtEntryPoint;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/login").permitAll()

                // 🔒 শুধুমাত্র MARCH পাবে march/** এর access
                .requestMatchers("/march/**").hasRole("MARCH")

                // 🔒 DESIGN নিজে পাবে, MARCH তো সব পায়ই
                .requestMatchers("/design/**").hasAnyRole("MARCH", "DESIGN")

                // 🔒 FABRIC নিজে পাবে, MARCH পাবে
                .requestMatchers("/fabric/**").hasAnyRole("MARCH", "FABRIC")

                // 🔒 CUTTING
                .requestMatchers("/cutting/**").hasAnyRole("MARCH", "CUTTING")

                // 🔒 SEWING
                .requestMatchers("/sewing/**").hasAnyRole("MARCH", "SEWING")

                // 🔒 FINISHING
                .requestMatchers("/finishing/**").hasAnyRole("MARCH", "FINISHING")

                // 🔒 QC
                .requestMatchers("/qc/**").hasAnyRole("MARCH", "QC")

                // 🔒 WAREHOUSE
                .requestMatchers("/warehouse/**").hasAnyRole("MARCH", "WAREHOUSE")

                // 🔒 SHIPPING
                .requestMatchers("/shipping/**").hasAnyRole("MARCH", "SHIPPING")

                .anyRequest().authenticated()
            )
            .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtEntryPoint))
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

*/



/*
 * 
package com.sunshine.sunspring.config;

import com.sunshine.sunspring.security.JwtEntryPoint;
import com.sunshine.sunspring.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final JwtEntryPoint jwtEntryPoint;

    public SecurityConfig(JwtFilter jwtFilter, JwtEntryPoint jwtEntryPoint) {
        this.jwtFilter = jwtFilter;
        this.jwtEntryPoint = jwtEntryPoint;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(authorize -> authorize
            // USE requestMatchers instead of antMatchers
            .requestMatchers("/api/login").permitAll()
            .requestMatchers("/march/**").hasRole("MARCH")
            .requestMatchers("/design/**").hasRole("DESIGN")
            .requestMatchers("/fabric/**").hasRole("FABRIC")
            .requestMatchers("/cutting/**").hasRole("CUTTING")
            .requestMatchers("/sewing/**").hasRole("SEWING")
            .requestMatchers("/finishing/**").hasRole("FINISHING")
            .requestMatchers("/qc/**").hasRole("QC")
            .requestMatchers("/warehouse/**").hasRole("WAREHOUSE")
            .requestMatchers("/shipping/**").hasRole("SHIPPING")
            .anyRequest().authenticated()
          )
          .exceptionHandling(ex -> ex
            .authenticationEntryPoint(jwtEntryPoint)
          )
          .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
      AuthenticationConfiguration config
    ) throws Exception {
        return config.getAuthenticationManager();
    }
}


*/

package com.sunshine.sunspring.config;

import com.sunshine.sunspring.security.JwtEntryPoint;
import com.sunshine.sunspring.security.JwtFilter;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final JwtEntryPoint jwtEntryPoint;

    public SecurityConfig(JwtFilter jwtFilter, JwtEntryPoint jwtEntryPoint) {
        this.jwtFilter = jwtFilter;
        this.jwtEntryPoint = jwtEntryPoint;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/notices/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/notices/**").authenticated()
                .requestMatchers(HttpMethod.GET,"/api/tender/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/tender/**").authenticated()
                .requestMatchers(HttpMethod.GET,"/api/circuler/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/circuler/**").authenticated()
                .requestMatchers(HttpMethod.GET, "/api/employee/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/employee/**").authenticated()
                .requestMatchers(HttpMethod.GET, "/api/attendence/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/attendence/**").authenticated()
                .requestMatchers("api/report/**").authenticated()
                .requestMatchers("/march/**").hasRole("MARCH")
                .requestMatchers("/design/**").hasAnyRole("MARCH", "DESIGN")
                .requestMatchers("/fabric/**").hasAnyRole("MARCH", "DESIGN", "FABRIC")
                .requestMatchers("/cutting/**").hasAnyRole("MARCH", "DESIGN", "FABRIC", "CUTTING")
                .requestMatchers("/sewing/**").hasAnyRole("MARCH", "DESIGN", "FABRIC", "CUTTING", "SEWING")
                .requestMatchers("/finishing/**").hasAnyRole("MARCH", "DESIGN", "FABRIC", "CUTTING", "SEWING", "FINISHING")
                .requestMatchers("/qc/**").hasAnyRole("MARCH", "DESIGN", "FABRIC", "CUTTING", "SEWING", "FINISHING", "QC")
                .requestMatchers("/warehouse/**").hasAnyRole("MARCH", "DESIGN", "FABRIC", "CUTTING", "SEWING", "FINISHING", "QC", "WAREHOUSE")
                .requestMatchers("/shipping/**").hasAnyRole("MARCH", "DESIGN", "FABRIC", "CUTTING", "SEWING", "FINISHING", "QC", "WAREHOUSE", "SHIPPING")
                .anyRequest().authenticated())
            .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
            .and()
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy("""
            ROLE_MARCH > ROLE_DESIGN
            ROLE_DESIGN > ROLE_FABRIC
            ROLE_FABRIC > ROLE_CUTTING
            ROLE_CUTTING > ROLE_SEWING
            ROLE_SEWING > ROLE_FINISHING
            ROLE_FINISHING > ROLE_QC
            ROLE_QC > ROLE_WAREHOUSE
            ROLE_WAREHOUSE > ROLE_SHIPPING
        """);
        return hierarchy;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));  // Use List.of(...) for clarity
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true); // Allow credentials like JWT

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}


 


