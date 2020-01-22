package com.gzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()//内存验证
            .passwordEncoder(getEncode())//编码器(对输入得进行编码)
            .withUser("user")//明文
            .password("$2a$10$eC5.kZocA.iFX.j1daDc7./FdSx7ZdDxKTpJJ2fLYZ8mYwYUgmria")//密文
            .roles("USER");
    }
    
	public static void main(String[] args) {
		String encode = getEncode().encode("pass");
		System.out.println(encode);
	}
	
	private static BCryptPasswordEncoder getEncode() {
		return new BCryptPasswordEncoder();
	}

}