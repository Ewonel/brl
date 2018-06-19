package cz.legas.brl.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${security.basic.ignored:}")
    private String[] basicIgnoredMatchers;

    @Value("${security.basic-web.enabled:false}")
    private boolean basicEnabled;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity authentication = basicEnabled ?
                http
                        .authorizeRequests()
                        .antMatchers(basicIgnoredMatchers).permitAll()
                        .antMatchers("/**").hasAnyRole("USER")
                        .and()
                        .httpBasic()
                        .and() :
                http
                        .httpBasic().disable();

        authentication
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .csrf().disable()
                .logout().disable();
    }
}
