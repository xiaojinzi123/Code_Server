package com.xiaojinzi.code.modular.dynamics.pojo;

import com.xiaojinzi.code.modular.comment.pojo.BugComment;

/**
 * Created by xiaojinzi on 2016/10/28.
 * desc:动态,展示在首页
 */
public class BugDynamics extends Dynamics {

    /**
     * 这个评论是最佳的评论
     */
    private BugComment bugComment;

    public BugComment getBugComment() {
        return bugComment;
    }

    public void setBugComment(BugComment bugComment) {
        this.bugComment = bugComment;
    }


}
