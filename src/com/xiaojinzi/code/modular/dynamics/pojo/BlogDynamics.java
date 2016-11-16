package com.xiaojinzi.code.modular.dynamics.pojo;

/**
 * Created by xiaojinzi on 2016/11/2.
 * desc:博文的动态
 */
public class BlogDynamics extends Dynamics {



    /**
     * 动态的类别<br/>
     * 0:原创<br/>
     * 1:引用<br/>
     */
    private Integer tag1;

    public Integer getTag1() {
        return tag1;
    }

    public void setTag1(Integer tag1) {
        this.tag1 = tag1;
    }

}
