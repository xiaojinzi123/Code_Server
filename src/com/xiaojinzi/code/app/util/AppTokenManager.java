package com.xiaojinzi.code.app.util;


import com.xiaojinzi.code.util.Md5Util;

/**
 * 客户端的token管理器
 */
public class AppTokenManager {

    /**
     * 返回一个MD5的token
     *
     * @return
     */
    public static String getAppToken() {

        String md5 = Md5Util.MD5("appToken" + System.currentTimeMillis());
        if (md5 == null) {
            md5 = "" + System.currentTimeMillis();
        }
        return md5;
    }

}
