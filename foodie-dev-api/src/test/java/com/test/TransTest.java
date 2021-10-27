package com.test;

import com.imooc.Application;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import com.imooc.service.TestTransService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: chengho
 * @create: 2021-10-23 16:15
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private TestTransService testTransService;

    @Autowired
    private TestTransService testTransaction;

    @Autowired
    private StuService stuService;

//    @Test
    public void myTest() {
        testTransaction.testPropagationTrans();

    }




}
