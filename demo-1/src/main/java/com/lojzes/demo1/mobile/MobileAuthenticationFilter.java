package com.lojzes.demo1.mobile;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/22 20:02
 */
public class MobileAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public static final String SPRING_SECURITY_FORM_phone_KEY = "mobile";

    private String usernameParameter = SPRING_SECURITY_FORM_phone_KEY;
    private boolean postOnly = true;

    protected MobileAuthenticationFilter() {
        super(new AntPathRequestMatcher("/sys/mobile", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String mobile = request.getParameter(usernameParameter);

        if (mobile == null) {
            mobile = "";
        }

        mobile = mobile.trim();

        MobileAuthenticationToken authRequest = new MobileAuthenticationToken(mobile);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
