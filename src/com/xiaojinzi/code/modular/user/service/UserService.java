package com.xiaojinzi.code.modular.user.service;

import com.xiaojinzi.code.modular.base.service.BaseService;
import com.xiaojinzi.code.modular.user.pojo.User;
import com.xiaojinzi.code.util.Result;

/**
 * Created by xiaojinzi on 2016/10/26.
 * desc:用户的业务对象
 */
public interface UserService extends BaseService<User, Integer> {

    /**
     * 注册一个用户
     *
     * @param user
     * @param result
     * @return
     */
    boolean register(User user, Result<User> result);

    /**
     * 登陆
     *
     * @param user
     * @param result
     * @return
     */
    boolean login(User user, Result<User> result);

    /**
     * 电话号码是否存在
     *
     * @param phoneNumber
     * @return
     */
    boolean isPhoneExist(String phoneNumber);

    /**
     * 微博的id是否存在
     *
     * @param weiBoId
     * @return
     */
    boolean isWeiBoIdExist(String weiBoId);

    /**
     * 微信的id是否存在
     *
     * @param weiXinId
     * @return
     */
    boolean isWeiXinIdExist(String weiXinId);

    /**
     * qq的id是否存在
     *
     * @param qqId
     * @return
     */
    boolean isQqIdExist(String qqId);

    /**
     * 用户名是否存在
     *
     * @param name
     * @return
     */
    User isNameExist(String name);

    /**
     * 根据手机号和密码登陆
     *
     * @param user
     * @return
     */
    User queryByPhoneAndPassword(User user);

}
