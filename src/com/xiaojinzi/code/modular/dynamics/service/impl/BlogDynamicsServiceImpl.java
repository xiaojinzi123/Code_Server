package com.xiaojinzi.code.modular.dynamics.service.impl;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.base.service.BaseServiceImpl;
import com.xiaojinzi.code.modular.dynamics.dao.BlogDynamicsMapper;
import com.xiaojinzi.code.modular.dynamics.pojo.BlogDynamics;
import com.xiaojinzi.code.modular.dynamics.queryBean.DynamicsQuery;
import com.xiaojinzi.code.modular.dynamics.service.BlogDynamicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaojinzi on 2016/10/28.
 * desc:博文动态的业务对象
 */
@Service("blogDynamicsService")
public class BlogDynamicsServiceImpl extends BaseServiceImpl<BlogDynamics> implements BlogDynamicsService {

    @Autowired
    BlogDynamicsMapper blogDynamicsMapper;

    @Transactional
    @Override
    public List<BlogDynamics> queryForList(DynamicsQuery dynamicsQuery) {
        return blogDynamicsMapper.queryForList(dynamicsQuery);
    }

    @Override
    protected BaseDao<BlogDynamics, Integer> getBaseDao() {
        return blogDynamicsMapper;
    }

}
