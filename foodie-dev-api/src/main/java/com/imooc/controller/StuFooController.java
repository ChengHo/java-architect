package com.imooc.controller;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: Foo 示例
 * @author: chengho
 * @create: 2021-10-21 22:27
 */
@RestController
public class StuFooController {

    @Autowired
    private StuService stuService;


    @GetMapping("/getStuInfo")
    public Stu getStuInfo(int id) {
        return stuService.getStuInfo(id);
    }


}
