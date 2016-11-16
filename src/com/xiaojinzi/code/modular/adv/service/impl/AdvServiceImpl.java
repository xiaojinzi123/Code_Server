package com.xiaojinzi.code.modular.adv.service.impl;

import com.xiaojinzi.code.modular.adv.dao.AdvMapper;
import com.xiaojinzi.code.modular.adv.pojo.Adv;
import com.xiaojinzi.code.modular.adv.service.AdvService;
import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.base.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaojinzi on 2016/10/30.
 * desc:
 */
@Service("advService")
public class AdvServiceImpl extends BaseServiceImpl<Adv> implements AdvService {

    @Autowired
    AdvMapper advMapper;

    @Override
    protected BaseDao<Adv, Integer> getBaseDao() {
        return advMapper;
    }

}
