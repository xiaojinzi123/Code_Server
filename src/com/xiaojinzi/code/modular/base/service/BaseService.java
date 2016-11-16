package com.xiaojinzi.code.modular.base.service;



import com.xiaojinzi.code.util.Result;

import java.util.List;

/**
 * Created by cxj on 2016/8/13.
 */
public interface BaseService<T, PK> {

    T queryById(PK pk);

    List<T> queryAll();

    boolean insert(T t, Result<T> result);

    boolean update(T t, Result<T> result);

    boolean deleteById(PK pk, Result<T> result);

}
