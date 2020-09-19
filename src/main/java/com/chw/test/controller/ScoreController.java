package com.chw.test.controller;


import com.alibaba.fastjson.JSON;
import com.chw.test.service.ScoreService;
import com.chw.test.service.StudentService;
import com.chw.test.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-19
 */
@RestController
@RequestMapping("/score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;

    @Resource
    private SysUserService sysUserService;

    @Resource
    private StudentService studentService;

    @GetMapping("/testOne")
    public String testOne(){
        return JSON.toJSONString(scoreService.list());
    }

    @GetMapping("/testTwo")
    public String testTwo(){
        return JSON.toJSONString(sysUserService.getAllUser());
    }

    @GetMapping("/testThree")
    public String testThree(){
        return JSON.toJSONString(sysUserService.list());
    }

    @GetMapping("/testFour/{id}")
    public String testFour(@PathVariable("id") Integer id){
        return sysUserService.saveUser(id);
    }

    @GetMapping("/testFive/{id}")
    public String testFive(@PathVariable("id") Integer id){
        return studentService.saveStudent(id);
    }



}
