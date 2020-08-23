package com.lsytest.demo.hightasks.impl;

import com.lsy.base.date.DateHelper;
import com.lsy.base.result.ResultVo;
import com.lsy.mybatisplus.plugins.Page;
import com.lsy.mybatisplus.service.impl.ServiceImpl;
import com.lsy.mybatisplus.toolkit.CollectionUtils;
import com.lsytest.demo.base.dto.BaseDTO;
import com.lsytest.demo.base.utils.ComUtil;
import com.lsytest.demo.hightasks.entity.TaskEntity;
import com.lsytest.demo.hightasks.enums.TaskLevelEnum;
import com.lsytest.demo.hightasks.enums.TaskStatusEnum;
import com.lsytest.demo.hightasks.mapper.TaskMapper;
import com.lsytest.demo.hightasks.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class TaskServiceImpl extends ServiceImpl<TaskMapper, TaskEntity> implements ITaskService{
    @Autowired
    private TaskMapper taskMapper;

    /**
     * 新增任务信息
     *
     * @param queryMap
     * @param baseDTO
     * @return
     */
    @Override
    public ResultVo queryList(Map<String, Object> queryMap, BaseDTO baseDTO) {
        Page<Map<String,Object>> page = new Page<>();
        page.setCurrent(baseDTO.getCurrent());
        page.setSize(baseDTO.getPageSize());
        List<Map<String,Object>>  respMapList = taskMapper.queryList(queryMap,page);
        if(CollectionUtils.isNotEmpty(respMapList)){
            for(Map<String,Object> tempMap:respMapList){
                tempMap.put("taskLevelName", TaskLevelEnum.getLabel(ComUtil.objToStr(tempMap.get("taskLevel"))));
                tempMap.put("taskStatusName", TaskStatusEnum.getLabel(ComUtil.objToStr(tempMap.get("taskStatus"))));
            }
        }
        page.setRecords(respMapList);
        ResultVo resultVo = new ResultVo();
        resultVo.setError_no(0);
        resultVo.setResult(page);
        return resultVo;
    }

    /**
     * 新增任务信息
     *
     * @param taskEntity
     * @param baseDTO
     * @return
     */
    @Override
    public ResultVo addTask(TaskEntity taskEntity, BaseDTO baseDTO) {
        taskEntity.setTaskId(taskEntity.getTaskIdNo());
        taskEntity.setCreateBy(baseDTO.getUserId());
        taskEntity.setCreateDate(DateHelper.formatTime(new Date()));
        taskMapper.insert(taskEntity);
        ResultVo resultVo = new ResultVo();
        resultVo.setError_no(0);
        resultVo.setError_info("OK");
        return resultVo;
    }

    /**
     * 编辑任务信息
     *
     * @param taskEntity
     * @param baseDTO
     * @return
     */
    @Override
    public ResultVo editTask(TaskEntity taskEntity, BaseDTO baseDTO) {
        taskEntity.setUpdateBy(baseDTO.getUserId());
        taskEntity.setUpdateDate(DateHelper.formatTime(new Date()));
        taskMapper.updateById(taskEntity);
        ResultVo resultVo = new ResultVo();
        resultVo.setError_no(0);
        resultVo.setError_info("OK");
        return resultVo;
    }
}
