package com.xiaojinzi.code.app.programingLanguage;

import com.xiaojinzi.code.app.util.ResponseUtil;
import com.xiaojinzi.code.modular.programingLanguage.pojo.ProLan;
import com.xiaojinzi.code.modular.programingLanguage.service.ProLanService;
import com.xiaojinzi.code.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaojinzi on 2016/11/12.
 * desc:
 */
@Controller
@RequestMapping("app/proLan")
public class AppProLanController {

    @Autowired
    ProLanService proLanService;

    @RequestMapping("queryAllProLan")
    public void queryAllProLan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ProLan> proLans = proLanService.queryAll();
        ResponseUtil.setMsgInfo(true, Msg.OK, proLans, null, response);
    }

}
