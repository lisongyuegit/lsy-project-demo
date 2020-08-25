package com.lsytest.demo.hightasks.mapper;

import com.lsy.mybatisplus.mapper.BaseMapper;
import com.lsy.mybatisplus.plugins.Page;
import com.lsytest.demo.hightasks.entity.TaskEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public interface TaskMapper extends BaseMapper<TaskEntity> {
    /**
     * 新增任务信息
     *
     * @param queryMap
     * @param Page
     * @return
     */
    List<Map<String, Object>> queryList(@Param("queryMap") Map<String, Object> queryMap, @Param("page") Page Page);
}
