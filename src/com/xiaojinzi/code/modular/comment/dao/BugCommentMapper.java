package com.xiaojinzi.code.modular.comment.dao;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.comment.pojo.BugComment;
import com.xiaojinzi.code.modular.comment.queryBean.CommentQuery;

import java.util.List;

/**
 * Created by xiaojinzi on 2016/11/4.
 * desc:Bug评论的数据库操作接口
 */
public interface BugCommentMapper extends BaseDao<BugComment, Integer> {

    /**
     * 分页查询Bug评论
     *
     * @param query 查询条件封装
     * @return
     */
    List<BugComment> queryForList(CommentQuery query);

}
