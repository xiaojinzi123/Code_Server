package com.xiaojinzi.code.app.dynamics;

import com.xiaojinzi.code.app.util.ResponseUtil;
import com.xiaojinzi.code.modular.dynamics.pojo.BlogDynamics;
import com.xiaojinzi.code.modular.dynamics.pojo.BugDynamics;
import com.xiaojinzi.code.modular.dynamics.queryBean.DynamicsQuery;
import com.xiaojinzi.code.modular.dynamics.service.BlogDynamicsService;
import com.xiaojinzi.code.modular.dynamics.service.BugDynamicsService;
import com.xiaojinzi.code.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaojinzi on 2016/10/28.
 * desc:App动态有关的操作
 */
@Controller
@RequestMapping("app/dynamics")
public class AppDynamicsController {

    /**
     * Bug的动态业务对象
     */
    @Autowired
    BugDynamicsService bugDynamicsService;

    /**
     * 博文的动态业务对象
     */
    @Autowired
    BlogDynamicsService blogDynamicsService;

    /**
     * 根据id查询Bug动态
     *
     * @param dynamicsId
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("queryForBugById")
    public void queryForBugById(Integer dynamicsId,
                                HttpServletRequest request, HttpServletResponse response) throws IOException {

        BugDynamics bugDynamic = bugDynamicsService.queryById(dynamicsId);

        //响应给客户端
        ResponseUtil.setMsgInfo(true, Msg.OK, bugDynamic, null, response);

    }

    /**
     * 分页查询Bug动态数据
     *
     * @param timestamp 时间戳
     * @param proLanId  编程语言id
     * @param request   请求对象
     * @param response  响应对象
     * @throws IOException
     */
    @RequestMapping("queryForBugList")
    public void queryForBugList(Long timestamp, Integer proLanId,
                                HttpServletRequest request, HttpServletResponse response) throws IOException {

        //构建查询条件
        DynamicsQuery query = new DynamicsQuery();

        if (timestamp == null || timestamp <= 0) {
            query.setTimestamp(System.currentTimeMillis());
        } else {
            query.setTimestamp(timestamp);
        }

        query.setProLanId(proLanId);

        //查询当前页的动态
        List<BugDynamics> bugDynamics = bugDynamicsService.queryForList(query);

        //响应给客户端
        ResponseUtil.setMsgInfo(true, Msg.OK, bugDynamics, null, response);

    }

    /**
     * 分页查询Bug动态数据
     *
     * @param timestamp 时间戳
     * @param request   请求对象
     * @param response  响应对象
     * @throws IOException
     */
    @RequestMapping("queryForBlogList")
    public void queryForBlogList(Long timestamp,
                                 HttpServletRequest request, HttpServletResponse response) throws IOException {

        //构建查询条件
        DynamicsQuery query = new DynamicsQuery();

        if (timestamp == null || timestamp <= 0) {
            query.setTimestamp(System.currentTimeMillis());
        } else {
            query.setTimestamp(timestamp);
        }

        //查询当前页的动态
        List<BlogDynamics> blogDynamics = blogDynamicsService.queryForList(query);

        //响应给客户端
        ResponseUtil.setMsgInfo(true, Msg.OK, blogDynamics, null, response);

    }


}
