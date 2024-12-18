package com.artemissoftware.springboot.todo_web_app.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager


@Configuration
class SpringSecurityConfiguration {

    @Bean
    fun createUserDetailsManager(): InMemoryUserDetailsManager{
        val userDetails1 = createNewUser("Test", "1234")
        val userDetails2 = createNewUser("Milo", "12")

        return InMemoryUserDetailsManager(userDetails1, userDetails2)
    }

    private fun createNewUser(username: String, password: String): UserDetails {
        return User.builder()
            .passwordEncoder{ input -> passwordEncoder().encode(input) }
            .username(username)
            .password(password)
            .roles("USER", "ADMIN")
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}