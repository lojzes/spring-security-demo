package com.lojzes.demo1.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/21 16:19
 */
@Controller
public class IndexController {

  @GetMapping("index")
  public ModelAndView index(ModelAndView modelAndView ) {
      modelAndView.setViewName("index");
      modelAndView.addObject("username",
              SecurityContextHolder.getContext().getAuthentication().getPrincipal());
      return modelAndView;
  }
}
