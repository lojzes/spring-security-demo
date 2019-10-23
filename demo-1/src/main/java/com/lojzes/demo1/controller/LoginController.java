package com.lojzes.demo1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/21 16:23
 */
@Slf4j
@Controller
@RequestMapping("sys")
public class LoginController {

  @GetMapping("/loginPage")
  public ModelAndView loginPage(
      ModelAndView modelAndView,@RequestParam(value = "msg",required = false) String msg) {
    modelAndView.setViewName("login");
    modelAndView.addObject("msg",msg);
    return modelAndView;
  }

    @GetMapping("loginError")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("loginError");
        return modelAndView;
    }

    @GetMapping("/mobilePage")
    public ModelAndView mobilePage(
            ModelAndView modelAndView,@RequestParam(value = "msg",required = false) String msg) {
        modelAndView.setViewName("login-mobile");
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }


}
