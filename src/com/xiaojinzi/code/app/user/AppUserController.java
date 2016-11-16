package com.xiaojinzi.code.app.user;

import com.xiaojinzi.code.app.util.ResponseUtil;
import com.xiaojinzi.code.modular.user.pojo.User;
import com.xiaojinzi.code.modular.user.service.UserService;
import com.xiaojinzi.code.util.Msg;
import com.xiaojinzi.code.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaojinzi on 2016/10/26.
 * desc:
 */
@Controller
@RequestMapping("app/user")
public class AppUserController {

    @Autowired
    UserService userService;

    @RequestMapping("register")
    public void register(User user,
                      HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result<User> result = new Result<User>();
        boolean b = userService.register(user, result);
        if (b) { //如果注册成功
            ResponseUtil.setMsgInfo(true, Msg.OK, result.entity, null, response);
        } else {
            ResponseUtil.setMsgInfo(false, result.resultText, null, null, response);
        }
    }

    /**
     * App登陆响应
     *
     * @param request  请求对象
     * @param response 响应
     */
    @RequestMapping("login")
    public void login(User user,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result<User> result = new Result<User>();
        boolean b = userService.login(user, result);
        if (b) { //如果登陆成功
            ResponseUtil.setMsgInfo(true, Msg.OK, result.entity, null, response);
        } else {
            ResponseUtil.setMsgInfo(false, result.resultText, null, null, response);
        }
    }

}
