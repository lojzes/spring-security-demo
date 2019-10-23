package com.lojzes.demo1.mobile;

import com.lojzes.demo1.userdetail.SysUserDetailService;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/22 20:37
 */
public class MobileSecurityConfigurerAdapter
    extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
  @Setter private SysUserDetailService sysUserDetailService;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    MobileAuthenticationFilter mobileAuthenticationFilter = new MobileAuthenticationFilter();
    mobileAuthenticationFilter.setAuthenticationManager(
        http.getSharedObject(AuthenticationManager.class));

    MobileAuthenticationProvider mobileAuthenticationProvider = new MobileAuthenticationProvider();
    mobileAuthenticationProvider.setSysDetailsService(sysUserDetailService);
    http.authenticationProvider(mobileAuthenticationProvider)
        .addFilterAfter(mobileAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
