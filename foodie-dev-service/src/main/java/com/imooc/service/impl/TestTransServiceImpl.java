package com.imooc.service.impl;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import com.imooc.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: chengho
 * @create: 2021-10-23 16:19
 */
@Service
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StuService stuService;

    /**
     * 事务传播: - Propagation
     *      REQUIRED:   事务默认传播方式。常用于增、删、改
     *                  使用当前的事务，如果当前没有事务，则自己新建一个事务，子方法必须运行在一个事务中；
     *                  如果当前存在事务，则加入这个事务，成为一个整体
     *                  eg: 领导没饭吃，我有钱，我会自己买了自己吃；领导有的吃，会分给你一起吃。
     *      SUPPORTS:   主要用于查询，不会回滚。
     *                  如果当前有事务，则使用事务；如果当前没有事务，则不使用事务。
     *                  eg: 领导没饭吃，我也没饭吃；领导有饭吃，我也有饭吃。
     *      MANDATORY:  该传播属性强制必须存在一个事务，如果不存在，则抛出异常
     *                  eg: 领导必须管饭，不管饭没饭吃，我就不乐意了，就不干了（抛出异常）
     *      REQUIRES_NEW:   如果当前有事务，则挂起当前事务，并自己创建一个新事务的事务给自己使用；
     *                      如果当前没有事务，则与 REQUIRED 等效
     *                      eg: 领导有饭吃，我偏不要，我自己买了自己吃。
     *      NOT_SUPPORTED:  如果当前有事务，则将当前事务挂起，自己不使用事务去运行数据库操作。
     *                      eg: 领导有饭吃，分一点给你，我太忙了，放一边，我不吃。
     *      NEVER:      如果当前有事务存在，则抛出异常。
     *                  eg: 领导有饭给你吃，我不想吃，我热爱工作，我跑出异常。
     *      NESTED:     如果当前有事务，则开启子事务（嵌套事务），嵌套事务是独立提交或回滚；
     *                  如果当前没有事务，则同 REQUIRED .
     *                  但如果主事务提交，则会携带子事务一起提交。
     *                  如果主事务回滚，则子事务一起回滚；相反，子事务回滚，则父事务可以回滚或不回滚。
     *                  eg: 领导决策不对，老板怪罪，领导带着小弟一同受罚。小弟出错，领导可以推卸责任。
     */
//    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();

        stuService.saveChildren();

    }
}
