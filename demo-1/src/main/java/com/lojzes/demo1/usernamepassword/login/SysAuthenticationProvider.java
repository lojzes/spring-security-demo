package com.lojzes.demo1.usernamepassword.login;

import com.lojzes.demo1.userdetail.SysUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/22 10:17
 */
@Service
public class SysAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private SysUserDetailService sysUserDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails = sysUserDetailService.loadUserByUsername(username);

        if(null == userDetails){
            throw new UsernameNotFoundException("用户不存在");
        }

        if(!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("密码错误");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(username,password,userDetails.getAuthorities());
        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
