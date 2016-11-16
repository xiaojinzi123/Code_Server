package com.xiaojinzi.code.modular.popularStar.pojo;

import com.xiaojinzi.code.modular.base.entity.BaseEntity;
import com.xiaojinzi.code.modular.user.pojo.User;

/**
 * Created by xiaojinzi on 2016/11/3.
 * desc:人气明星
 */
public class PopularStar extends BaseEntity {

    private Integer id;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
