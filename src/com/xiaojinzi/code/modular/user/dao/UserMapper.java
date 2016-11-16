package com.xiaojinzi.code.modular.user.dao;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.user.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Created by xiaojinzi on 2016/10/26.
 * desc:用户的数据库操作接口
 */
@Repository
public interface UserMapper extends BaseDao<User, Integer> {


    /**
     * 根据电话号码查询用户
     *
     * @param phoneNumber
     * @return
     */
    User queryByPhoneNumber(String phoneNumber);

    /**
     * 根据微博的id查询用户
     *
     * @param weiBoId
     * @return
     */
    User queryByWeiBoId(String weiBoId);

    /**
     * 根据微信的id查询用户
     *
     * @param weiXinId
     * @return
     */
    User queryByWeiXinId(String weiXinId);

    /**
     * 根据qq的id查询用户
     *
     * @param qqId
     * @return
     */
    User queryByQqId(String qqId);

    /**
     * 根据userName查询用户
     *
     * @param userName
     * @return
     */
    User queryByUserName(String userName);

    /**
     * 根据手机号和密码登陆
     * @param user 用户对象
     * @return
     */
    User queryByPhoneAndPassword(User user);

}
