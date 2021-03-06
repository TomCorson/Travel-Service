package travel.travel_API.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import travel.travel_API.Security.JWTAuthenticationEntryPoint;
import travel.travel_API.Security.JwtAuthenticationProvider;
import travel.travel_API.Security.JwtAuthenticationTokenFilter;
import travel.travel_API.Security.JwtSuccessHandler;

import java.util.Collections;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationProvider authenticationProvider;
    @Autowired
    private JWTAuthenticationEntryPoint entryPoint;

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter(){
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("**/lodging/**").authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }


}
