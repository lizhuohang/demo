package com.lzh.demo.web.controller;

import com.lzh.demo.web.module.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lizhuohang on 17/1/18.
 */
@Controller
public class JsonController {
    @RequestMapping(value="/json/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Shop getShopInJSON(@PathVariable String name) {
        System.out.println("-----请求json数据--------");
        Shop shop = new Shop();
        shop.setName(name);
        shop.setAddress("address:"+name);
        shop.setProducts((int)(Math.random() * 10000));
        return shop;
    }
}
