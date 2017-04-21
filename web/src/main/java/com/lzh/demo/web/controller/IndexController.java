package com.lzh.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lizhuohang on 17/1/18.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index")
    public String index() {
        System.out.println("------index------");
        return "index";
    }

    @RequestMapping(value = "/index1")
    public ModelAndView index1() {
        System.out.println("------index1------");
        ModelAndView m = new ModelAndView("index1");
        m.getModel().put("name", "hello world");
        return m;
    }
}
