package com.lojzes.demo1.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Slf4j
@Component
public class MyLogoutSuccessHandlerOne implements LogoutSuccessHandler {
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		if(authentication != null) {
			log.info(authentication.getName());
		}
		log.error("logout------------------------------");
		String URL = request.getContextPath() + "/sys/loginPage?msg="+
                URLEncoder.encode("退出成功，请重新登录","utf-8");
		response.setStatus(HttpStatus.OK.value());
		response.sendRedirect(URL);
	}
} 