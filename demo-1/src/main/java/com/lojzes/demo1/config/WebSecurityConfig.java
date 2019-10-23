package com.lojzes.demo1.config;

import com.lojzes.demo1.handler.MyLogoutSuccessHandlerOne;
import com.lojzes.demo1.mobile.MobileSecurityConfigurerAdapter;
import com.lojzes.demo1.userdetail.SysUserDetailService;
import com.lojzes.demo1.usernamepassword.login.SysAuthenticationProvider;
import com.lojzes.demo1.usernamepassword.login.SysSavedRequestAwareAuthenticationSuccessHandler;
import com.lojzes.demo1.usernamepassword.login.SysSimpleUrlAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private SysAuthenticationProvider sysAuthenticationProvider;

  @Autowired
  private SysSavedRequestAwareAuthenticationSuccessHandler
      sysSavedRequestAwareAuthenticationSuccessHandler;

  @Autowired
  private SysSimpleUrlAuthenticationFailureHandler sysSimpleUrlAuthenticationFailureHandler;

  @Autowired private MyLogoutSuccessHandlerOne myLogoutSuccessHandler;
    @Autowired
    private SysUserDetailService sysUserDetailService;

  //  @Override
  //  @Bean
  //  public UserDetailsService userDetailsService() {
  //    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
  //    manager.createUser(
  //        User.withDefaultPasswordEncoder()
  //            .username("user")
  //            .password("123")
  //            .roles("ADMIN", "DBA")
  //            .build());
  //    return manager;
  //  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/sys/**")
        .permitAll()
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
        .antMatchers("/db/**")
        .access("hasRole('ADMIN') and hasRole('DBA')")
        .anyRequest()
        .authenticated();
    //
    http.formLogin()
        .loginPage("/sys/loginPage")
        .loginProcessingUrl("/login")
        .successHandler(sysSavedRequestAwareAuthenticationSuccessHandler)
        .failureHandler(sysSimpleUrlAuthenticationFailureHandler)
        .permitAll();
    //
    http.logout()
        .deleteCookies("remove")
        .invalidateHttpSession(false)
        .logoutUrl("/logout")
        .logoutSuccessHandler(myLogoutSuccessHandler);
    // .addLogoutHandler(logoutHandler)
    //  .deleteCookies(cookieNamesToClear)

    http.csrf().disable();

      http.apply(MobileSecurityConfigurerAdapter());
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(sysAuthenticationProvider);
  }

  @Bean
  public MobileSecurityConfigurerAdapter MobileSecurityConfigurerAdapter() {
      MobileSecurityConfigurerAdapter mobileSecurityConfigurerAdapter =
              new MobileSecurityConfigurerAdapter();
    mobileSecurityConfigurerAdapter.setSysUserDetailService(sysUserDetailService);
      return mobileSecurityConfigurerAdapter;
  }
}
