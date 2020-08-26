package com.lsytest.demo.hightasks.entity;

import com.lsy.mybatisplus.annotations.TableField;
import com.lsy.mybatisplus.annotations.TableId;
import com.lsy.mybatisplus.annotations.TableName;
import com.lsy.mybatisplus.enums.IdType;
import com.lsytest.demo.base.utils.ComUtil;

import java.io.Serializable;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
@TableName("t_bus_high_tasks")
public class TaskEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *任务id
     */
    @TableField("task_id")
    private String taskId;
    /**
     *用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     *任务名称
     */
    @TableField("task_name")
    private String taskName;
    /**
     *任务等级
     */
    @TableField("task_level")
    private String taskLevel;
    /**
     *任务等级
     */
    @TableField("task_status")
    private String taskStatus;
    /**
     * 任务分析
     */
    @TableField("task_analysis")
    private String taskAnalysis;
    /**
     * 任务进展
     */
    @TableField("task_progress")
    private String taskProgress;
    /**
     *当前处理人
     */
    @TableField("handle")
    private String handle;
    /**
     *任务开始时间
     */
    @TableField("start_date")
    private String startDate;
    /**
     *任务结束时间
     */
    @TableField("end_date")
    private String endDate;
    /**
     *创建时间
     */
    @TableField("create_date")
    private String createDate;
    /**
     *创建人
     */
    @TableField("create_by")
    private String createBy;
    /**
     *更新时间
     */
    @TableField("update_date")
    private String updateDate;
    /**
     *更新人
     */
    @TableField("update_by")
    private String updateBy;
    /**
     *备注
     */
    @TableField("remark")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(String taskLevel) {
        this.taskLevel = taskLevel;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskIdNo(){
        return ComUtil.getNo();
    }
}
