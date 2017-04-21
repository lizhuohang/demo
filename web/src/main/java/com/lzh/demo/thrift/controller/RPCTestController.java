package com.lzh.demo.thrift.controller;

import com.lzh.demo.thrift.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/rpc/test", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RPCTestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RPCTestController.class);

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Integer> result(
            @RequestParam(value = "ip", required = false, defaultValue = "localhost") String ip,
            @RequestParam(value = "port", required = false, defaultValue = "8081") Integer port,
            @RequestParam(value = "num1", required = false, defaultValue = "100") Integer num1,
            @RequestParam(value = "num2", required = false, defaultValue = "100") Integer num2) {
        Map<String, Integer> result = new HashMap<>();
        result.put("result", requestService.add(ip, port, num1, num2));
        return result;
    }
}
