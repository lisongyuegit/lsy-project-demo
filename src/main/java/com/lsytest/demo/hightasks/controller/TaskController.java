package com.lsytest.demo.hightasks.controller;

import com.lsy.base.result.ResultVo;
import com.lsy.base.string.StringHelper;
import com.lsy.mybatisplus.mapper.EntityWrapper;
import com.lsytest.demo.base.dto.BaseDTO;
import com.lsytest.demo.base.utils.ComUtil;
import com.lsytest.demo.hightasks.entity.TaskEntity;
import com.lsytest.demo.hightasks.enums.TaskLevelEnum;
import com.lsytest.demo.hightasks.enums.TaskStatusEnum;
import com.lsytest.demo.hightasks.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
@RestController
@RequestMapping("/lsy/demo/task")
public class TaskController {
    @Autowired
    private ITaskService taskService;

    /**
     * 新增任务
     *
     * @param queryMap
     * @param baseDTO
     * @return
     */
    @GetMapping(value = "list")
    public ResultVo list(@RequestParam Map queryMap, @ModelAttribute BaseDTO baseDTO) {
        if (StringHelper.isBlank(ComUtil.objToStr(queryMap.get("startDate")))) {
            queryMap.put("startDate", LocalDate.now().toString());
        }
        if (StringHelper.isBlank(ComUtil.objToStr(queryMap.get("taskStatus")))) {
            queryMap.put("notTaskStatus", TaskStatusEnum.FINISH.getValue());
        }
        if (StringHelper.isNotBlank(ComUtil.objToStr(queryMap.get("taskStatus")))) {
            TaskStatusEnum.checkValue(ComUtil.objToStr(queryMap.get("taskStatus")));
        }
        if (StringHelper.isNotBlank(ComUtil.objToStr(queryMap.get("taskLevel")))) {
            TaskLevelEnum.checkValue(ComUtil.objToStr(queryMap.get("taskLevel")));
        }
        return taskService.queryList(queryMap, baseDTO);
    }

    /**
     * 新增任务
     *
     * @param taskEntity
     * @param baseDTO
     * @return
     */
    @PostMapping(value = "add")
    public ResultVo addTask(@ModelAttribute TaskEntity taskEntity, @ModelAttribute BaseDTO baseDTO) {
        return taskService.addTask(taskEntity, baseDTO);
    }

    /**
     * 编辑任务
     *
     * @param taskEntity
     * @param baseDTO
     * @return
     */
    @PostMapping(value = "edit")
    public ResultVo edit(@ModelAttribute TaskEntity taskEntity, @ModelAttribute BaseDTO baseDTO) {
        ResultVo resultVo = new ResultVo();
        if (StringHelper.isBlank(taskEntity.getTaskId())) {
            resultVo.setError_no(-1);
            resultVo.setError_info("taskId不能为空");
            return resultVo;
        }
        EntityWrapper<TaskEntity> query = new EntityWrapper<>();
        query.eq("task_Id", taskEntity.getTaskId());
        TaskEntity respTask = taskService.selectOne(query);
        if (null == respTask) {
            resultVo.setError_no(-1);
            resultVo.setError_info("任务不存在");
            return resultVo;
        }
        taskEntity.setId(respTask.getId());
        return taskService.editTask(taskEntity, baseDTO);
    }

    @PutMapping(value = "/finish")
    public ResultVo finish(@ModelAttribute TaskEntity taskEntity, @ModelAttribute BaseDTO baseDTO) {
        ResultVo resultVo = new ResultVo();
        if (StringHelper.isBlank(taskEntity.getTaskId())) {
            resultVo.setError_no(-1);
            resultVo.setError_info("taskId不能为空");
            return resultVo;
        }
        EntityWrapper<TaskEntity> query = new EntityWrapper<>();
        query.eq("task_Id", taskEntity.getTaskId());
        TaskEntity respTask = taskService.selectOne(query);
        if (null == respTask) {
            resultVo.setError_no(-1);
            resultVo.setError_info("任务不存在");
            return resultVo;
        }
        respTask.setTaskStatus(TaskStatusEnum.FINISH.getValue());
        taskService.updateById(respTask);
        resultVo.setError_no(0);
        resultVo.setError_info("OK");
        return resultVo;
    }
}
