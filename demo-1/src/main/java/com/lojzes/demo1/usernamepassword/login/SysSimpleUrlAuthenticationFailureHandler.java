package com.lojzes.demo1.usernamepassword.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/22 14:27
 */
@Slf4j
@Service
public class SysSimpleUrlAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登陆失败...." + exception.getMessage());
        String url = request.getContextPath() +"sys/loginPage?msg="+ URLEncoder.encode(exception.getMessage(),"utf-8");
        redirectStrategy.sendRedirect(request,response,url);
    }
}
