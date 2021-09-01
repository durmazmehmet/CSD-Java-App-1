package org.csystem.springboot.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
public class PostalCodeSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        var adminUser = User.withDefaultPasswordEncoder()
                .username("oguz")
                .password("csd1993")
                .authorities("ADMIN", "USER")
                .build();

        var normalUser = User.withDefaultPasswordEncoder()
                .username("test")
                .password("test1234")
                .authorities("USER")
                .build();

        var disabledUser = User.withDefaultPasswordEncoder()
                .username("lokman")
                .password("lokman")
                .authorities("USER")
                .disabled(true)
                .build();

        auth.inMemoryAuthentication()
                .withUser(adminUser)
                .withUser(normalUser)
                .withUser(disabledUser);
    }
}
