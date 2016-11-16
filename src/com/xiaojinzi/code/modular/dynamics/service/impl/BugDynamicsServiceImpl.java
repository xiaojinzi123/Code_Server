package com.xiaojinzi.code.modular.dynamics.service.impl;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.base.service.BaseServiceImpl;
import com.xiaojinzi.code.modular.dynamics.dao.BugDynamicsMapper;
import com.xiaojinzi.code.modular.dynamics.pojo.BugDynamics;
import com.xiaojinzi.code.modular.dynamics.queryBean.DynamicsQuery;
import com.xiaojinzi.code.modular.dynamics.service.BugDynamicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaojinzi on 2016/10/28.
 * desc:
 */
@Service("bugDynamicsService")
public class BugDynamicsServiceImpl extends BaseServiceImpl<BugDynamics> implements BugDynamicsService {

    @Autowired
    BugDynamicsMapper bugDynamicsMapper;

    @Transactional
    @Override
    public List<BugDynamics> queryForList(DynamicsQuery dynamicsQuery) {
        return bugDynamicsMapper.queryForList(dynamicsQuery);
    }

    @Override
    protected BaseDao<BugDynamics, Integer> getBaseDao() {
        return bugDynamicsMapper;
    }
}
