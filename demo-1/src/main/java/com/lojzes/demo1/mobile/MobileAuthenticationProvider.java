package com.lojzes.demo1.mobile;

import com.lojzes.demo1.userdetail.SysDetailsService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/22 20:14
 */
public class MobileAuthenticationProvider implements AuthenticationProvider {
  @Setter @Getter private SysDetailsService sysDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String mobile = (String) authentication.getPrincipal();

    UserDetails userDetails = sysDetailsService.loadUserByMobile(mobile);

    MobileAuthenticationToken mobileAuthenticationToken =
        new MobileAuthenticationToken(mobile, userDetails.getAuthorities());
    return mobileAuthenticationToken;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return MobileAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
