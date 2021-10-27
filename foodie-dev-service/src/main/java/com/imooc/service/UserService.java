package com.imooc.service;

/**
 * @description:
 * @author: chengho
 * @create: 2021-10-25 23:35
 */
public interface UserService {

    /**
     * 校验用户是否已经存在
     */
    public boolean queryUserNameIsExist(String username);
}
