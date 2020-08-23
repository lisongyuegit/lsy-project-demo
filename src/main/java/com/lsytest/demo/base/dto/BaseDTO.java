package com.lsytest.demo.base.dto;

import com.lsy.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class BaseDTO implements Serializable{
    /**
     *用户id
     */
    private String userId;

    private Integer current = 1;

    private Integer pageSize = 20;

    private String userToken;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
