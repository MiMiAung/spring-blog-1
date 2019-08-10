package demo.example.blogspring1.security;

import demo.example.blogspring1.service.UserDetailServiesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity

public class WebMVCSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDetailServiesImpl userDetailServie;

    public WebMVCSecurity(UserDetailServiesImpl userDetailServie) {
        this.userDetailServie = userDetailServie;
   }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                .antMatchers("/").permitAll()
                .antMatchers("/posts").permitAll()
                .antMatchers("/authors").permitAll()
                .antMatchers("/post").hasRole("ADMIN")
                .antMatchers("/author").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .httpBasic()
               // .loginPage("/login")
              //  .permitAll()

                ;



    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailServie).passwordEncoder(bCryptPasswordEncoder);
    }
}
