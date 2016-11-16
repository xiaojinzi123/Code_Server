package com.xiaojinzi.code.modular.dynamics.service;

import com.xiaojinzi.code.modular.base.service.BaseService;
import com.xiaojinzi.code.modular.dynamics.pojo.BugDynamics;
import com.xiaojinzi.code.modular.dynamics.queryBean.DynamicsQuery;

import java.util.List;

/**
 * Created by xiaojinzi on 2016/10/28.
 * desc:动态的业务对象
 */
public interface BugDynamicsService extends BaseService<BugDynamics,Integer> {

    /**
     * 分页查询动态
     *
     * @param dynamicsQuery 查询条件的包装类
     * @return
     */
    List<BugDynamics> queryForList(DynamicsQuery dynamicsQuery);

}
