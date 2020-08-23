package com.lsytest.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/lsy/test")
public class TestModeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/run",method = RequestMethod.GET)
    public String testRun(@RequestParam Map map){
        String result = "";
        try{
            logger.info("页面输入参数为: " + map);
            result = "你好,欢迎!";
        }catch(Exception e){
            result = "代码运行错误" + e;
            e.printStackTrace();
            return result;
        }
        return result;

    }
//我要测试
}
