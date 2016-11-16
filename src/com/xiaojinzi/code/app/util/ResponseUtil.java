package com.xiaojinzi.code.app.util;

import com.google.gson.Gson;
import com.xiaojinzi.code.util.Msg;
import com.xiaojinzi.code.util.StatusCodeConstant;
import net.sf.json.JsonConfig;

import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by cxj on 2016/8/13.
 */
public class ResponseUtil {

    /**
     * 设置json返回的数据和提示信息,没有返回的实体对象
     *
     * @param isOk     是否是成功的
     * @param msgText  提示信息
     * @param cfg      json配置信息
     * @param response 响应对象
     * @throws IOException 可能抛出的异常
     */
    public static void setMsgInfo(boolean isOk, String msgText, JsonConfig cfg, ServletResponse response)
            throws IOException {
        setMsgInfo(isOk, msgText, null, cfg, response);
    }

    /**
     * 设置json返回的数据和提示信息
     *
     * @param isOk     是否是成功的
     * @param msgText  提示信息
     * @param data     返回的数据,会转化成json
     * @param cfg      json的配置
     * @param response 响应对象
     * @throws IOException 可能抛出的异常
     */
    public static void setMsgInfo(boolean isOk, String msgText, Object data, JsonConfig cfg, ServletResponse response)
            throws IOException {
        setMsgInfo(isOk ? StatusCodeConstant.NORMAL : StatusCodeConstant.NORMAL_ERROR, msgText, data, cfg, response);
    }

    /**
     * 设置json返回的数据和提示信息
     *
     * @param statusCode 状态码
     *                   {@link StatusCodeConstant#NOACCESS}
     *                   {@link StatusCodeConstant#NORMAL_ERROR}
     *                   {@link StatusCodeConstant#TOKENINVALID}
     *                   {@link StatusCodeConstant#NOACCESS}
     * @param msgText    提示信息
     * @param data       返回的数据,会转化成json
     * @param cfg        json的配置
     * @param response   响应对象
     * @throws IOException
     */
    public static void setMsgInfo(int statusCode, String msgText, Object data, JsonConfig cfg, ServletResponse response)
            throws IOException {
        Msg msg = new Msg();
        msg.setData(data);
        msg.setStatusCode(statusCode);
        msg.setMsgText(msgText);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Gson g = new Gson();
        String result = g.toJson(msg);
        response.getWriter().write(result);
//        if (cfg == null) {
//            response.getWriter().write(JSONObject.fromObject(msg).toString());
//        } else {
//            response.getWriter().write(JSONObject.fromObject(msg, cfg).toString());
//        }
    }

}
