package com.xiaojinzi.code.modular.programingLanguage.pojo;

import com.xiaojinzi.code.modular.base.entity.BaseEntity;

/**
 * Created by xiaojinzi on 2016/10/29.
 * desc:编程语言
 */
public class ProLan extends BaseEntity {

    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
