package com.example.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login //  フォーム認証を使う
				.loginPage("/login") //  loginが必要な時、このURLに対応するページを送出する
				.permitAll()) //  フォーム認証画面は認証不要
				.authorizeHttpRequests(authz -> authz						
						.requestMatchers("/**").permitAll()
						.requestMatchers("/css/**", "/login", "/signup", "/register").permitAll() // CSSファイルは認証不要          
						.requestMatchers("/").permitAll() //  トップページは認証不要
						.requestMatchers("/create/**").hasRole("ADMIN") // アクセス制限
						.requestMatchers("/delete/**").hasRole("ADMIN") // アクセス制限
						.anyRequest().authenticated() //  他のURLはログイン後アクセス可能
				);

		return http.build();
	}
}