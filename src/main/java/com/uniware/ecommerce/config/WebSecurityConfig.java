package com.uniware.ecommerce.config;


import com.uniware.ecommerce.util.Constant;
import com.uniware.ecommerce.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /*
         * 1. Se desactiva el uso de cookies
         * 2. Se activa la configuración CORS con los valores por defecto
         * 3. Se desactiva el filtro CSRF
         * 4. Se indica que el login no requiere autenticación
         * 5. Se indica que el resto de URLs esten securizadas
         */
        httpSecurity
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/token").permitAll()
                .antMatchers(HttpMethod.GET, Constant.WebPaths.ARTICLES).permitAll()
                .antMatchers(HttpMethod.GET, Constant.WebPaths.MANUFACTURERS,
                        Constant.WebPaths.MANUFACTURERS + "/**").permitAll()
                .antMatchers(HttpMethod.GET, Constant.WebPaths.BRANDS + "**").permitAll()
                .antMatchers(Constant.WebPaths.SHOPPING_CARTS, Constant.WebPaths.SHOPPING_CARTS + "/**").permitAll()
                .anyRequest().authenticated().and()
                .addFilterAfter(getFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public JwtAuthenticationFilter getFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
