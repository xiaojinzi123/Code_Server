package com.xiaojinzi.code.app.adv;

import com.xiaojinzi.code.app.util.ResponseUtil;
import com.xiaojinzi.code.modular.adv.pojo.Adv;
import com.xiaojinzi.code.modular.adv.service.AdvService;
import com.xiaojinzi.code.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaojinzi on 2016/10/30.
 * desc:广告的App控制器
 */
@Controller
@RequestMapping("app/adv")
public class AdvController {

    @Autowired
    AdvService advService;

    /**
     * 分页查询动态数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("queryAllAdv")
    public void queryAllAdv(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Adv> advs = advService.queryAll();

        ResponseUtil.setMsgInfo(true, Msg.OK, advs, null, response);

    }

}
