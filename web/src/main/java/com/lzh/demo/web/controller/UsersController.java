package com.lzh.demo.web.controller;

import com.lzh.demo.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by lizhuohang on 17/1/18.
 */
@Controller
public class UsersController {
    @Resource(name="userService")
    private UserService service;

    @RequestMapping(value="/manager",method= RequestMethod.GET)
    public ModelAndView hello2(){
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("message", "HelloMVC");
        return mv;
    }

    @RequestMapping(value="/count",method=RequestMethod.GET)
    public ModelAndView count(){
        int c = service.userCount();
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", c);
        mv.setViewName("users");
        return mv;
    }
}
