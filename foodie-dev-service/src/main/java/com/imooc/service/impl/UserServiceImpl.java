package com.imooc.service.impl;

import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.DateUtil;
import com.imooc.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @description:
 * @author: chengho
 * @create: 2021-10-25 23:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String DEFAULT_FACE_ID = "https://cn.bing.com/images/search?view=detailV2&ccid=g2Cn3O0c&id=E43350EFE20BF45E54F55777DB26A132512509CB&thid=OIP.g2Cn3O0cpLOukWNQXiSVAwHaHa&mediaurl=https%3a%2f%2fts1.cn.mm.bing.net%2fth%2fid%2fR-C.8360a7dced1ca4b3ae9163505e249503%3frik%3dywklUTKhJtt3Vw%26riu%3dhttp%253a%252f%252fbpic.588ku.com%252felement_pic%252f01%252f55%252f09%252f6257474dbc567d0.jpg%26ehk%3dnXrFcGC04TsymuA3yHvU99yBg1sIVjhB8QdpjLqBsow%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=260&expw=260&q=%e9%bb%98%e8%ae%a4%e5%a4%b4%e5%83%8f&simid=608036780788285954&FORM=IRPRST&ck=B1E35A99324B821107CB9662252AAF8C&selectedIndex=107&ajaxhist=0&ajaxserp=0";

//    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUserNameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);

        Users users = usersMapper.selectOneByExample(userExample);

//        System.out.println(users.toString());
        boolean result = false;
        if (users != null) {
            result = true;
        }
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {

        String userId = sid.nextShort();

        Users users = new Users();
        users.setId(userId);
        users.setUsername(userBO.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 默认昵称为用户名
        users.setNickname(userBO.getUsername());
        // 默认头像
        users.setFace(DEFAULT_FACE_ID);
        // 默认生日
        users.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // 默认性别: 保密
        users.setSex(Sex.secret.type);

        users.setCreatedTime(new Date());

        users.setUpdatedTime(new Date());

        usersMapper.insert(users);

        return users;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        usersMapper.selectOneByExample(userExample);

        return null;
    }
}
