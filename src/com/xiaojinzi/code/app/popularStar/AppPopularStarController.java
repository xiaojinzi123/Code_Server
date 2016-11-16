package com.xiaojinzi.code.app.popularStar;

import com.xiaojinzi.code.app.util.ResponseUtil;
import com.xiaojinzi.code.modular.popularStar.pojo.PopularStar;
import com.xiaojinzi.code.modular.popularStar.service.PopularStarService;
import com.xiaojinzi.code.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaojinzi on 2016/11/3.
 * desc:
 */
@Controller
@RequestMapping("app/popularStar")
public class AppPopularStarController {

    @Autowired
    PopularStarService popularStarService;

    /**
     * 查询所有的人气明星
     *
     * @param request  请求对象
     * @param response 响应对象
     * @throws IOException
     */
    @RequestMapping("queryAllPopularStar")
    public void queryAllPopularStar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<PopularStar> popularStars = popularStarService.queryAll();
        ResponseUtil.setMsgInfo(true, Msg.OK, popularStars, null, response);
    }

}
