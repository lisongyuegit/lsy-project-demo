package com.lsytest.demo.enums;


import java.util.Arrays;
import java.util.List;

/**
 * 数据导入导出场景枚举定义
 * @author chenyanfa@edenep.net
 * @version 2.0
 * @description:
 * @copyright: Copyright (c) 2017
 * @company: 易登科技
 * @since 2018-5-7 15:22
 */
public enum DataImportExportSceneEnum {

    /**
     * 1 设备
     */
    EQUIPMENT(1, "设备"),
    /**
     * 2 设施
     */
    FACILITY(2, "设施"),
    /**
     * 3 车辆
     */
    VEHICLE(3, "车辆"),
    /**
     * 4 车辆加油记录
     */
    VEHICLE_REFUEL(4, "车辆加油记录"),
    /**
     * 5 员工信息
     */
    EMPLOYEE(5, "员工信息"),

    /**
     * 6 运营设备
     */
    DEVICE(6, "运营设备"),
    /**
     * 7 人资管理——员工信息
     */
    HR_EMPLOYEE(7, "人资管理——员工信息"),
    /**
     * 8 人资管理——员工信息
     */
    MM_VEHICLE(8, "物资管理——车辆信息");

    private int value;
    private String label;
    DataImportExportSceneEnum(int value, String label) {
        this.value = value;
        this.label = label;
    }


    public int getValue() {
        return value;
    }

    public static DataImportExportSceneEnum checkValue(int value) throws Exception{
        List<DataImportExportSceneEnum> list = Arrays.asList(DataImportExportSceneEnum.values());
        for (DataImportExportSceneEnum employeeRoleEnum : list) {
            if (employeeRoleEnum.value == value) {
                return employeeRoleEnum;
            }
        }

        throw new Exception("参数有误");
    }
}

