package uk.ac.city.aczg113.Manjaros.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uk.ac.city.aczg113.Manjaros.entities.RestaurantUser;
import uk.ac.city.aczg113.Manjaros.services.RestaurantUserDetails;


import javax.sql.DataSource;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private RestaurantUserDetails restaurantUserDetails;

    @Autowired
    public SecurityConfig(DataSource  dataSource, RestaurantUserDetails restaurantUserDetails){
        this.dataSource = dataSource;
        this.restaurantUserDetails = restaurantUserDetails;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email, password, 'TRUE' as enabled FROM RESTAURANT_USER WHERE email=?")
                .authoritiesByUsernameQuery("SELECT email, 'ROLE_USER' as authority FROM RESTAURANT_USER WHERE email=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests()
                .antMatchers("/feedback", "/Contact Us")
                .permitAll()
                .antMatchers("/profile")
                .authenticated()
                .and()
                .formLogin();


        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

   @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider
            = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(restaurantUserDetails);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

}
