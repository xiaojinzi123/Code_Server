package com.xiaojinzi.code.modular.base.dao;


import java.util.List;

/**
 * Created by cxj on 2016/8/13
 * 数据库操作的基本操作
 */
public interface BaseDao<T, PK> {

    /**
     * 根据主键查询一个对象
     *
     * @param pk
     * @return
     */
    T queryById(PK pk);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> queryAll();

    /**
     * 插入一个对象
     *
     * @param t
     * @return
     */
    void insert(T t) throws Exception;

    /**
     * 更新一个对象
     *
     * @param t
     * @return
     */
    void update(T t) throws Exception;

    /**
     * 删除一个对象
     *
     * @param pk
     * @return
     */
    void delete(PK pk) throws Exception;

}
