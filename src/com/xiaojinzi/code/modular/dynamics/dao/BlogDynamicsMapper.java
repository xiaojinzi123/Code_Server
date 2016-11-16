package com.xiaojinzi.code.modular.dynamics.dao;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.dynamics.pojo.BlogDynamics;
import com.xiaojinzi.code.modular.dynamics.pojo.Dynamics;
import com.xiaojinzi.code.modular.dynamics.queryBean.DynamicsQuery;

import java.util.List;

/**
 * Created by xiaojinzi on 2016/10/28.
 * desc:
 */
public interface BlogDynamicsMapper extends BaseDao<BlogDynamics, Integer> {

    /**
     * 分页查询动态
     *
     * @param dynamicsQuery 查询条件的包装类
     * @return
     */
    List<BlogDynamics> queryForList(DynamicsQuery dynamicsQuery);

}
