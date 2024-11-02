package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin1234"))
				.roles("ADMIN")
				.build();
		
		UserDetails student = User
				.withUsername("student")
				.password(passwordEncoder().encode("student5674"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin,student);
				
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login //フォーム認証を使う約束
			.permitAll())	
			.authorizeHttpRequests(authz -> authz          //
					.requestMatchers("/Hello").permitAll()
					.requestMatchers("layouts/Header","layouts/Footer","layouts/layout").permitAll()//ヘッダーフッターのログイン不要許可
					.requestMatchers("/About","/Privacy","Terms").permitAll()
					.requestMatchers("/css/**").permitAll()// (/css以下)のファイルは認証不要
					.requestMatchers("/public/**").permitAll()//publicフォルダ内はログイン不要
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/").permitAll()//requestMatcher(カッコ内のリンクと一致しとるなら).permitAll（認証無しでええよ）
					.anyRequest().permitAll()//anyRequest(上記のリンク以外)はauthenticated(ログイン必要だよ)って記述
					);
		return http.build();
		//正確に言えばbuild()の戻り値はSecurityFilterChainインターフェースを実装したorg.springframework.security.web.DefaultSecurityFilterChainクラスである ↩︎
		
	}
	
}