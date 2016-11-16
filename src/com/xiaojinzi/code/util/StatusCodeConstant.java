package com.xiaojinzi.code.util;

/**
 * Created by xiaojinzi on 2016/8/25.
 * desc:状态码的集中解释
 * 1-100表示比较重大的状态码农,占用了
 */
public class StatusCodeConstant {

    /**
     * 表示请求正常
     */
    public static final int NORMAL = 0;

    /**
     * 普通的错误,比如账号密码错误之类的
     */
    public static final int NORMAL_ERROR = 1;

    /**
     * Token失效的错误,是一个特殊错误
     * 此时客户端需要退出登录,否则即使
     * 请求也是没有任何的数据能正常返回
     */
    public static final int TOKENINVALID = 2;

    /**
     * 被禁止登陆系统
     */
    public static final int NOACCESS = 3;

}
