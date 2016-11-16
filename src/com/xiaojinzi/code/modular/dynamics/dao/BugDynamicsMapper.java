package com.xiaojinzi.code.modular.dynamics.dao;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.dynamics.pojo.BugDynamics;
import com.xiaojinzi.code.modular.dynamics.pojo.Dynamics;
import com.xiaojinzi.code.modular.dynamics.queryBean.DynamicsQuery;

import java.util.List;

/**
 * Created by xiaojinzi on 2016/10/28.
 * desc:
 */
public interface BugDynamicsMapper extends BaseDao<BugDynamics, Integer> {

    /**
     * 分页查询动态
     *
     * @param dynamicsQuery 查询条件的包装类
     * @return
     */
    List<BugDynamics> queryForList(DynamicsQuery dynamicsQuery);

}
