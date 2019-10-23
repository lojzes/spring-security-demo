package com.lojzes.demo1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/21 15:22
 */
@RestController
@RequestMapping("db")
public class DbController {

    @GetMapping("info")
    public String getDbInfo(Model model){
        model.addAttribute("dbInfo","mysql-5.7");
        return "db";
    }
}
