package com.bosssoft.controller;

import com.bosssoft.entity.ApplyItem;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴志鸿
 * @date 2020/7/14
 * @description 测试xss拦截器，分别对表单提交数据和json格式数据进行拦截
 */
@Slf4j
@RestController
@RequestMapping(value = "/xsstest",produces = "application/json; charset=utf-8")
public class XssFilterController {

    private static Logger logger = LoggerFactory.getLogger(XssFilterController.class);

    @PostMapping("/form")
    public String testform(String name) {
        logger.info(name);
        return name;
    }

    @PostMapping("/json")
    public String testjson(@RequestBody ApplyItem applyItem) {
        logger.info(applyItem.getGoodsName());
        return applyItem.getGoodsName();
    }
}
