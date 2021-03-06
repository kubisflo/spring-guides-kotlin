package de.kubisflo.securingweb

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
//        super.configure(http)
        http?.run {
            authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()

            formLogin()
                .loginPage("/login")
                .permitAll()

            logout()
                .permitAll()
        }
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        val user: UserDetails = User.withDefaultPasswordEncoder()
            .username("kredi")
            .password("kredi")
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(user)
    }
}