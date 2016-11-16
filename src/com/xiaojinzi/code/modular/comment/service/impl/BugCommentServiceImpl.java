package com.xiaojinzi.code.modular.comment.service.impl;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.base.service.BaseServiceImpl;
import com.xiaojinzi.code.modular.comment.dao.BugCommentMapper;
import com.xiaojinzi.code.modular.comment.pojo.BugComment;
import com.xiaojinzi.code.modular.comment.queryBean.CommentQuery;
import com.xiaojinzi.code.modular.comment.service.BugCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaojinzi on 2016/11/4.
 * desc:
 */
@Service("bugCommentService")
public class BugCommentServiceImpl extends BaseServiceImpl<BugComment> implements BugCommentService {

    @Autowired
    BugCommentMapper bugCommentMapper;

    @Override
    protected BaseDao<BugComment, Integer> getBaseDao() {
        return bugCommentMapper;
    }

    @Transactional
    @Override
    public List<BugComment> queryForList(CommentQuery query) {
        return bugCommentMapper.queryForList(query);
    }
}
