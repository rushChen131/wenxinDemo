package com.wenxin.demo.controller;

import com.wenxin.demo.service.RequestService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

public class DemoController {


    @Resource
    private RequestService requestService;

    @RequestMapping("/getAccessToken")
    public String getAccessToken() {
        return requestService.getAccessToken();
    }


}
