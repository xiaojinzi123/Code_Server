package com.xiaojinzi.code.app.comment;

import com.xiaojinzi.code.app.DefultConstant;
import com.xiaojinzi.code.app.util.ResponseUtil;
import com.xiaojinzi.code.modular.comment.pojo.BugComment;
import com.xiaojinzi.code.modular.comment.queryBean.CommentQuery;
import com.xiaojinzi.code.modular.comment.service.BugCommentService;
import com.xiaojinzi.code.modular.dynamics.pojo.Dynamics;
import com.xiaojinzi.code.modular.user.pojo.User;
import com.xiaojinzi.code.util.Msg;
import com.xiaojinzi.code.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiaojinzi on 2016/11/4.
 * desc:
 */
@Controller
@RequestMapping("app/comment")
public class AppCommentController {

    @Autowired
    BugCommentService bugCommentService;

    /**
     * 分页获取评论
     *
     * @param timestamp  时间戳
     * @param dynamicsId 动态id
     * @param request    请求对象
     * @param response   响应对象
     * @throws IOException
     */
    @RequestMapping("queryForBugComment")
    public void queryForBugComment(Long timestamp, Integer dynamicsId,
                                   HttpServletRequest request, HttpServletResponse response) throws IOException {

        //构建查询条件
        CommentQuery query = new CommentQuery();

        if (timestamp == null || timestamp <= 0) {
            query.setTimestamp(System.currentTimeMillis());
        } else {
            query.setTimestamp(timestamp);
        }

        query.setDynamicsId(dynamicsId);

        //查询当前页的动态
        List<BugComment> bugComments = bugCommentService.queryForList(query);

        //响应给客户端
        ResponseUtil.setMsgInfo(true, Msg.OK, bugComments, null, response);

    }

    /**
     * 发布一个Bug的答案,也就是评论,楼主可以将一个或者多个评论当成是正确答案,会在App当中特别的显示
     *
     * @param dynamicsId   评论的动态
     * @param content      评论的内容
     * @param targetUserId @的用户
     * @param request      请求对象
     * @param response     响应对象
     * @throws IOException
     */
    public void postBugComment(Integer dynamicsId, String content, Integer targetUserId,
                               HttpServletRequest request, HttpServletResponse response) throws IOException {

        //拿到登陆的用户信息
        User user = (User) request.getAttribute(DefultConstant.DEFULT_AVATARADDRESS);

        BugComment bugComment = new BugComment();
        bugComment.setUser(user);
        bugComment.setTargetUser(new User(targetUserId));
        bugComment.setCommentTime(System.currentTimeMillis());
        bugComment.setContent(content);
        bugComment.setDynamics(new Dynamics(dynamicsId));

        Result<BugComment> result = new Result<BugComment>();

        boolean b = bugCommentService.insert(bugComment, result);

        if (b) {
            ResponseUtil.setMsgInfo(true, Msg.OK, null, response);
        } else {
            ResponseUtil.setMsgInfo(false, result.resultText, null, response);
        }

    }

}
