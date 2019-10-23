package com.lojzes.demo1.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/21 15:17
 */
@RestController
@RequestMapping("admin")
public class AdminController {

  @GetMapping("user")
  @ResponseBody
  public Object getCurrentUser() {
      String username = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      return username;
  }
}
