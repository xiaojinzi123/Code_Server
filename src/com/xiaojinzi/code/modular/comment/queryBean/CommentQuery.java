package com.xiaojinzi.code.modular.comment.queryBean;

import com.xiaojinzi.code.modular.base.queryPojo.BaseQuery;

/**
 * Created by xiaojinzi on 2016/11/4.
 * desc:
 */
public class CommentQuery extends BaseQuery {

    /**
     * 动态的id
     */
    private Integer dynamicsId;

    private long timestamp;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getDynamicsId() {
        return dynamicsId;
    }

    public void setDynamicsId(Integer dynamicsId) {
        this.dynamicsId = dynamicsId;
    }
}
