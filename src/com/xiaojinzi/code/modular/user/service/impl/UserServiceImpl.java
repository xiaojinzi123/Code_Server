package com.xiaojinzi.code.modular.user.service.impl;

import com.sun.istack.internal.NotNull;
import com.xiaojinzi.code.app.DefultConstant;
import com.xiaojinzi.code.app.util.AppTokenManager;
import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.base.service.BaseServiceImpl;
import com.xiaojinzi.code.modular.common.UserFilter;
import com.xiaojinzi.code.modular.user.dao.UserMapper;
import com.xiaojinzi.code.modular.user.pojo.User;
import com.xiaojinzi.code.modular.user.service.UserService;
import com.xiaojinzi.code.util.Result;
import com.xiaojinzi.code.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xiaojinzi on 2016/10/26.
 * desc:用户的业务对象
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    /**
     * 手机号码的正则表达式
     */
    private String phoneMatche = "^1[3|4|5|7|8][0-9]\\d{8}$";

    @Autowired
    UserMapper userMapper;

    @Override
    protected BaseDao<User, Integer> getBaseDao() {
        return userMapper;
    }

    /**
     * 注册的业务逻辑,可以通过<br/>
     * 1.手机号和密码注册<br/>
     * 2.微博id注册<br/>
     * 3.微信id注册<br/>
     * 4.qqid注册<br/>
     *
     * @param user
     * @param result
     * @return
     */
    @Transactional
    @Override
    public boolean register(User user, Result<User> result) {

        // 这个是为了给注册的时候的提供的一个默认的头像地址
        user.setAvatarAddress(DefultConstant.DEFULT_AVATARADDRESS);

        String checkResult = checkBeforRegister(user);

        if (checkResult == null) { //表示通过验证
            //生成appToken
            String clientToken = AppTokenManager.getAppToken();
            user.setClientToken(clientToken);
            //插入一个用户
            boolean b = insert(user, result);
            if (b) {
                result.entity = user;
                //过滤了信息
                UserFilter.filter(result.entity, false);
                return true;
            } else {
                result.entity = null;
            }
        } else {
            result.entity = null;
            result.resultText = checkResult;
        }
        return false;
    }


    /**
     * 登陆的逻辑
     *
     * @param user   要登陆的用户
     * @param result
     * @return
     */
    @Transactional
    public boolean login(User user, Result<User> result) {

        User resultUser = null;

        //获取电话号码
        String phoneNumber = user.getPhoneNumber();
        if (!StringUtil.isEmpty(phoneNumber)) { //如果使用电话号码登陆

            //手机号的正则
            boolean b = phoneNumber.matches(phoneMatche);
            if (!b) { //如果不匹配,提示用户
                result.resultText = "请输入正确的手机号";
                return false;
            }

            if (!StringUtil.isEmpty(user.getPassword())) {
                resultUser = queryByPhoneAndPassword(user);
                if (resultUser == null) {
                    result.resultText = "账号或者密码错误";
                    return false;
                }
            } else {
                result.resultText = "密码不能为空";
                return false;
            }
        }

        //到了这里的一定是登陆成功的那么生成一个clientToken
        if (resultUser == null) {
            result.resultText = "登陆失败";
            return false;
        } else {

            //生成appToken
            String clientToken = AppTokenManager.getAppToken();
            resultUser.setClientToken(clientToken);

            //主要是更新AppToken
            boolean b = update(resultUser, result);

            if (b) { //如果更新成功
                result.entity = resultUser;
                //过滤用户信息
                UserFilter.filter(result.entity, false);
            }
            return b;

        }

    }

    @Override
    public boolean improveUserInfo(User realUser, User user, Result<User> result) {

        //获取倒用户名
        String name = user.getName();

        if (StringUtil.isEmpty(name)) {
            result.resultText = "用户名不能为空";
            return false;
        }

        //获取倒头像地址
        String avatarAddress = user.getAvatarAddress();

        if (StringUtil.isEmpty(avatarAddress)) {
            result.resultText = "头像不能为空";
            return false;
        }

        //获取描述
        String description = user.getDescription();

        //名称是否重复
        User u = isNameExist(name);

        if (u == null) {
            result.resultText = "用户名已经存在";
            return false;
        }

        //设置更新的信息
        realUser.setName(name);
        realUser.setAvatarAddress(avatarAddress);
        realUser.setDescription(description);

        //执行更新
        return update(realUser, result);

    }

    /**
     * 注册之前的检测工作
     *
     * @param user 需要检测的用户
     * @return 如果返回null表示检测通过, 否则返回错误信息
     */
    private String checkBeforRegister(@NotNull User user) {

        //获取电话号码
        String phoneNumber = user.getPhoneNumber();
        if (!StringUtil.isEmpty(phoneNumber)) { //如果使用电话号码注册
            //手机号的正则
            boolean b = phoneNumber.matches(phoneMatche);
            if (!b) { //如果不匹配,提示用户
                return "请输入正确的手机号";
            }

            b = isPhoneExist(phoneNumber);
            if (b) { //如果存在
                return "手机号已注册";
            }

            if (!StringUtil.isEmpty(user.getPassword())) {
                return null; //表示通过验证
            } else {
                return "密码不能为空";
            }

        } else if (!StringUtil.isEmpty(user.getWeiboId())) {
            boolean b = isWeiBoIdExist(user.getWeiboId());
            if (b) { //如果存在
                return "微博号已注册";
            }
            return null; //表示通过验证
        } else if (!StringUtil.isEmpty(user.getWeixinId())) {
            boolean b = isWeiXinIdExist(user.getWeixinId());
            if (b) { //如果存在
                return "微信号已注册";
            }
            return null; //表示通过验证
        } else if (!StringUtil.isEmpty(user.getQqId())) {
            boolean b = isQqIdExist(user.getQqId());
            if (b) { //如果存在
                return "qq号已注册";
            }
            return null; //表示通过验证
        }
        return "注册信息不完整";
    }

    @Transactional
    @Override
    public boolean isPhoneExist(String phoneNumber) {
        User user = userMapper.queryByPhoneNumber(phoneNumber);
        return user == null ? false : true;
    }

    @Transactional
    @Override
    public boolean isWeiBoIdExist(String weiBoId) {
        User user = userMapper.queryByWeiBoId(weiBoId);
        return user == null ? false : true;
    }

    @Transactional
    @Override
    public boolean isWeiXinIdExist(String weiXinId) {
        User user = userMapper.queryByWeiXinId(weiXinId);
        return user == null ? false : true;
    }

    @Transactional
    @Override
    public boolean isQqIdExist(String qqId) {
        User user = userMapper.queryByQqId(qqId);
        return user == null ? false : true;
    }

    @Transactional
    @Override
    public User isNameExist(String name) {
        return userMapper.queryByUserName(name);
    }

    @Override
    public User queryByPhoneAndPassword(User user) {
        return userMapper.queryByPhoneAndPassword(user);
    }

}
