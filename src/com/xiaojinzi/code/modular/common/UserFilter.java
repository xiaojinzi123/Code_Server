package com.xiaojinzi.code.modular.common;


import com.xiaojinzi.code.modular.user.pojo.User;

import java.util.List;

/**
 * 因为用户这个对象中的信息是比较重要的,所以在输出的时候只能输出部分的信息,所有有关user对象<br/>
 * 输出之前都要经过这个类来过滤一下重要的信息
 *
 * @author cxj
 */
public class UserFilter {

    /**
     * 过滤掉一个User对象的重要信息
     *
     * @param user
     * @param isFilterAppToken 是否过滤掉token
     */
    public static void filter(User user, boolean isFilterAppToken) {
        if (isFilterAppToken) {
            user.setClientToken(null);
        }
        user.setImToken(null);
        user.setPassword(null);
        user.setPhoneNumber(null);
        user.setQqId(null);
        user.setUserType(null);
        user.setWeiboId(null);
        user.setWeixinId(null);
    }

    /**
     * 过滤一个集合的User对象
     *
     * @param users
     * @param isFilterAppToken 是否过滤掉token
     */
    public static void filter(List<User> users, boolean isFilterAppToken) {
        int size = users.size();
        for (int i = 0; i < size; i++) {
            filter(users.get(i), isFilterAppToken);
        }
    }

}
