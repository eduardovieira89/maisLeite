package com.leiteria.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.leiteria.security.jwt.AuthEntryPointJwt;
import com.leiteria.security.jwt.AuthTokenFilter;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class WebSecurityConfig implements WebMvcConfigurer {

	@Autowired
	UserDetailsService userDetailsService;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/**
		 * Isso não funciona:
		 http.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
		 
		 Nem isso:
		 http.csrf(csrf -> csrf.csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler())); 
		 **/
		
		http
		  .csrf(csrf -> csrf.disable())
		  .authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/**", "usuario/**").permitAll().anyRequest().authenticated())
				.logout((logout) -> logout.permitAll());
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

	@Bean
	AuthenticationManager customAuthenticationManager(UserDetailsService userDetailsService, PasswordEncoder encoder) {
		return authentication -> {
			String username = authentication.getPrincipal() + "";
			String password = authentication.getCredentials() + "";

			UserDetails user = userDetailsService.loadUserByUsername(username);

			if (!encoder.matches(password, user.getPassword())) {
				throw new BadCredentialsException("Bad credentials");
			}

			if (!user.isEnabled()) {
				throw new DisabledException("User account is not active");
			}

			return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
		};
	}

	@Bean
	AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
	}

	/**
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 *           http.cors().and().csrf().disable()
	 *           .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	 *           .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	 *           .authorizeRequests() .requestMatchers(HttpMethod.GET,
	 *           "/usuario/**").permitAll() .requestMatchers(HttpMethod.POST,
	 *           "/usuario/**").permitAll() .requestMatchers(HttpMethod.POST,
	 *           "/**").permitAll() .requestMatchers(HttpMethod.GET,
	 *           "/**").permitAll() .anyRequest().authenticated();
	 * 
	 *           http.addFilterBefore(authenticationJwtTokenFilter(),
	 *           UsernamePasswordAuthenticationFilter.class); }
	 * 
	 * @Bean
	 * @Override public AuthenticationManager authenticationManagerBean() throws
	 *           Exception { return super.authenticationManagerBean(); }
	 **/

	/**
	 * public WebSecurityConfig() { CorsConfiguration config = new
	 * CorsConfiguration();
	 * 
	 * // Possibly... // config.applyPermitDefaultValues()
	 * 
	 * config.setAllowCredentials(true);
	 * config.addAllowedOrigin("http://localhost:4200");
	 * config.addAllowedHeader("*"); config.addAllowedMethod("*");
	 * 
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * config);
	 * 
	 * CorsFilter filter = new CorsFilter(source); }
	 * 
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 *           registry.addMapping("/usuario/**")
	 *           .allowedOrigins("http://localhost:4200") .allowedMethods("GET",
	 *           "POST") .allowedHeaders("*") .exposedHeaders("*")
	 *           .allowCredentials(true); }
	 **/

	/**
	 * @Bean SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 *       http.cors().and() .authorizeHttpRequests()
	 *       .requestMatchers(HttpMethod.GET, "/usuario/**").permitAll()
	 *       .requestMatchers(HttpMethod.POST, "/usuario/**").permitAll()
	 *       .requestMatchers(HttpMethod.POST, "/**").permitAll()
	 *       .requestMatchers(HttpMethod.GET, "/**").permitAll()
	 *       .anyRequest().authenticated()
	 *       .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	 * 
	 *       http.addFilterBefore(authenticationJwtTokenFilter(),
	 *       UsernamePasswordAuthenticationFilter.class); return http.build();
	 * 
	 *       }
	 **/

	/**
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 *       WebMvcConfigurer() {
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 *           registry.addMapping("/**") .allowedOrigins("http://localhost:4200")
	 *           .allowedMethods("GET", "POST") .allowCredentials(true); } }; }
	 * 
	 * 
	 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
	 *       configuration = new CorsConfiguration();
	 *       configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	 *       configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
	 *       "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"));
	 *       UrlBasedCorsConfigurationSource source = new
	 *       UrlBasedCorsConfigurationSource();
	 *       source.registerCorsConfiguration("/**", configuration); return source;
	 *       }
	 **/
}
