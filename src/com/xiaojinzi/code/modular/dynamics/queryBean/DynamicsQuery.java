package com.xiaojinzi.code.modular.dynamics.queryBean;

import com.xiaojinzi.code.modular.base.queryPojo.BaseQuery;

/**
 * Created by xiaojinzi on 2016/10/28.
 * desc:
 */
public class DynamicsQuery extends BaseQuery {

    /**
     * 时间戳,返回的动态的时间戳都是小于这个时间戳的
     */
    private long timestamp;

    private Integer proLanId;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getProLanId() {
        return proLanId;
    }

    public void setProLanId(Integer proLanId) {
        this.proLanId = proLanId;
    }
}
