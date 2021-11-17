package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

/**
 * @description:
 * @author: chengho
 * @create: 2021-10-25 23:35
 */
public interface UserService {

    /**
     * 校验用户是否存在
     * @param username
     * @return
     */
    public boolean queryUserNameIsExist(String username);

    /**
     * 创建用户
     * @param userBO
     * @return
     */
    public Users createUser(UserBO userBO);

    /**
     * 登录校验用户名、密码
     * @param username
     * @param password
     * @return
     */
    public Users queryUserForLogin(String username, String password);

}
