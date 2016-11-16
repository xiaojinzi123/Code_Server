package com.xiaojinzi.code.modular.base.service;

import com.xiaojinzi.code.modular.base.dao.BaseDao;
import com.xiaojinzi.code.util.Result;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * Created by cxj on 2016/8/13.
 * 业务对象的基类
 */
public abstract class BaseServiceImpl<T> implements BaseService<T, Integer> {

    @Transactional
    @Override
    public T queryById(Integer id) {
        return getBaseDao().queryById(id);
    }

    @Transactional
    @Override
    public List<T> queryAll() {
        return getBaseDao().queryAll();
    }

    @Transactional
    @Override
    public boolean insert(T t, Result<T> result) {
        try {
            getBaseDao().insert(t);
            return true;
        } catch (Exception e) {
//            result.resultText = e.getMessage();
            e.printStackTrace();
            //回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Transactional
    @Override
    public boolean update(T t, Result<T> result) {
        try {
            getBaseDao().update(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id, Result<T> result) {
        try {
            if (id == null) {
                result.resultText = "id为空";
                return false;
            }
            getBaseDao().delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    /**
     * 获取数据库操作接口
     *
     * @return
     */
    protected abstract BaseDao<T, Integer> getBaseDao();

}
