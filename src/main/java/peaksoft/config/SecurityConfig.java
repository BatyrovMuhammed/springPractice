package peaksoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder =  User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Muhammed").password("krasavchik").roles("Student"))
                .withUser(userBuilder.username("Rahim").password("krasavchik-Rahim").roles("Manager"))
                .withUser(userBuilder.username("Nurullo").password("krasavchik-Nurullo").roles("HR","Manager"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("Student","Manager","HR")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info").hasRole("Manager")
                .and().formLogin().permitAll();


    }
}
