package com.lsytest.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class TestModeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/testRun",method = RequestMethod.GET)
    public String testRun(){
        String result = "测试成功";
        try{

        }catch(Exception e){
            result = "代码运行错误" + e;
            e.printStackTrace();
            return result;
        }
        return result;

    }

//    @RequestMapping("/getUsers")
//    public List<Map<String, Object>> getDbType(){
//        String sql = "select * from lsy_improt_config";
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        System.out.printf("数据库查询为:"+ JSONObject.toJSONString(list));
//        return list;
//    }


}
