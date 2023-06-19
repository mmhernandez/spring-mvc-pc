package com.mmhernandez.admindashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{	
		http
			// Allows allowing/restricting access based upon the HttpServletRequest
	    	.authorizeHttpRequests()
	    		// PathMatcher implementation for Ant-style path patterns 
	    		.requestMatchers("/admin/**").hasRole("ADMIN")
	    		// (here, we're allowing access to all endpoints other than "/" and "/home" to everyone..
            	.requestMatchers("/", "/home").authenticated()
	             // The mapping matches URLs using the following rules:
    				// ? matches one character
    				// * matches zero or more characters
    				// ** matches zero or more directories in a path
    				// {spring:[a-z]+} matches the regexp [a-z]+ as a path variable named "spring"
    				// Examples:
    					// com/t?st.jsp — matches com/test.jsp but also com/tast.jsp or com/txst.jsp
    					// com/*.jsp — matches all .jsp files in the com directory
						// com/**/test.jsp — matches all test.jsp files underneath the com path
    					// org/springframework/**/*.jsp — matches all .jsp files underneath the org/springframework path
    					// org/**/servlet/bla.jsp — matches org/springframework/servlet/bla.jsp but also org/springframework/testing/servlet/bla.jsp and org/servlet/bla.jsp
    					// com/{filename:\w+}.jsp will match com/test.jsp and assign the value test to the filename variable
            	.anyRequest().permitAll()
            	.and()
        	// Specifies to support form-based authentication. Now, our users are going to be authenticated via a FORM
            .formLogin()
            	.usernameParameter("email")	// ATTEMPTING TO CHANGE LOGIN PARAMETERS TO EMAIL/PW INSTEAD OF USERNAME/PW
                .permitAll()
                // Specifies the URL to send users to if login is required
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .and()
            // Provides logout support. 
                // The default is that accessing the URL "/logout" will log the user out by invalidating the HTTP Session,
                // cleaning up any rememberMe() authentication that was configured, clearing the SecurityContextHolder, 
                // and then redirect to "/login?success".
            .logout()
                .permitAll();
		
		return http.build();
	}
	
	// This method is configuring Spring Security to use our custom implementation of the UserDetailsService with Bcrypt.
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    } 
}
