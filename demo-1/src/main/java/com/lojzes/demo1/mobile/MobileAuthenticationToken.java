package com.lojzes.demo1.mobile;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/22 20:06
 */
public class MobileAuthenticationToken extends AbstractAuthenticationToken {
    private String mobile;

    public MobileAuthenticationToken(String mobile,Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.mobile = mobile;
    }

    public MobileAuthenticationToken(String mobile) {
        super(null);
        this.mobile = mobile;
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return mobile;
    }
}
