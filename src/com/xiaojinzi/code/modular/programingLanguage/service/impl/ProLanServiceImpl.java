package com.xiaojinzi.code.modular.programingLanguage.service.impl;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.modular.base.service.BaseServiceImpl;
import com.xiaojinzi.code.modular.programingLanguage.dao.ProLanMapper;
import com.xiaojinzi.code.modular.programingLanguage.pojo.ProLan;
import com.xiaojinzi.code.modular.programingLanguage.service.ProLanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaojinzi on 2016/11/12.
 * desc:
 */
@Service("proLanService")
public class ProLanServiceImpl extends BaseServiceImpl<ProLan> implements ProLanService {

    @Autowired
    ProLanMapper proLanMapper;

    @Override
    protected BaseDao<ProLan, Integer> getBaseDao() {
        return proLanMapper;
    }

}
