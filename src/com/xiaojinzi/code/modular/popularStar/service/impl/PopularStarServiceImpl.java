package com.xiaojinzi.code.modular.popularStar.service.impl;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.base.service.BaseServiceImpl;
import com.xiaojinzi.code.modular.popularStar.dao.PopularStarMapper;
import com.xiaojinzi.code.modular.popularStar.pojo.PopularStar;
import com.xiaojinzi.code.modular.popularStar.service.PopularStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaojinzi on 2016/11/3.
 * desc:
 */
@Service("popularStarService")
public class PopularStarServiceImpl extends BaseServiceImpl<PopularStar> implements PopularStarService {

    @Autowired
    PopularStarMapper popularStarMapper;

    @Override
    protected BaseDao<PopularStar, Integer> getBaseDao() {
        return popularStarMapper;
    }

}
