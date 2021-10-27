package com.imooc.service;

import com.imooc.pojo.Stu;

/**
 * @description:
 * @author: chengho
 * @create: 2021-10-21 22:19
 */
public interface StuService {

    public Stu getStuInfo(int id);

    public void saveStu();

    public void saveParent();

    public void saveChildren();

    public void updateStu();

    public void deleteStu(int id);
}
