package com.lsytest.demo.hightasks.service;

import com.lsy.base.result.ResultVo;
import com.lsy.mybatisplus.service.IService;
import com.lsytest.demo.base.dto.BaseDTO;
import com.lsytest.demo.hightasks.entity.TaskEntity;

import java.util.Map;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public interface ITaskService extends IService<TaskEntity>{
    /**
     * 新增任务信息
     * @param queryMap
     * @param baseDTO
     * @return
     */
    ResultVo queryList(Map<String, Object> queryMap, BaseDTO baseDTO);
    /**
     * 新增任务信息
     * @param taskEntity
     * @param baseDTO
     * @return
     */
    ResultVo addTask(TaskEntity taskEntity, BaseDTO baseDTO);

    /**
     * 编辑任务信息
     * @param taskEntity
     * @param baseDTO
     * @return
     */
    ResultVo editTask(TaskEntity taskEntity, BaseDTO baseDTO);
}
