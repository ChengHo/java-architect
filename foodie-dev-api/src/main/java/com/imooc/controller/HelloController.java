package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chengho
 * @create: 2021-10-20 21:44
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "Hello World ~";
    }

}
