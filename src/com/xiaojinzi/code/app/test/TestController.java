package com.xiaojinzi.code.app.test;

import com.xiaojinzi.code.app.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaojinzi on 2016/10/22.
 * desc:
 */
@RequestMapping("app/test")
@Controller
public class TestController {

    @RequestMapping("test")
    public void getDynamics(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResponseUtil.setMsgInfo(true, "hello", null, response);
    }

}
