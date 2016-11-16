package com.xiaojinzi.code.modular.comment.service;

import com.xiaojinzi.code.modular.base.service.BaseService;
import com.xiaojinzi.code.modular.comment.pojo.BugComment;
import com.xiaojinzi.code.modular.comment.queryBean.CommentQuery;

import java.util.List;

/**
 * Created by xiaojinzi on 2016/11/4.
 * desc:
 */
public interface BugCommentService extends BaseService<BugComment,Integer> {

    /**
     * 分页查询Bug评论
     *
     * @param query 查询条件封装
     * @return
     */
    List<BugComment> queryForList(CommentQuery query);


}
