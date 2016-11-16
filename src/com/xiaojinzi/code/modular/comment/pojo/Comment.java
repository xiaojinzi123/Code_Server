package com.xiaojinzi.code.modular.comment.pojo;

import com.xiaojinzi.code.modular.base.entity.BaseEntity;
import com.xiaojinzi.code.modular.dynamics.pojo.Dynamics;
import com.xiaojinzi.code.modular.user.pojo.User;

/**
 * Created by xiaojinzi on 2016/11/4.
 * desc:评论实体对象
 */
public class Comment extends BaseEntity {

    private Integer id;

    /**
     * 在哪个动态性下面发的,可能是Bug动态
     * 也可能是Blog动态
     */
    private Dynamics dynamics;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private long commentTime;

    /**
     * 发表评论的用户
     */
    private User user;

    /**
     * 评论针对的人
     */
    private User targetUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dynamics getDynamics() {
        return dynamics;
    }

    public void setDynamics(Dynamics dynamics) {
        this.dynamics = dynamics;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(long commentTime) {
        this.commentTime = commentTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }
}
