package com.chw.test.controller;


import com.chw.test.entity.*;
import com.chw.test.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-19
 */
@SuppressWarnings({"Duplicates"})
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/getRecord")
    public Map<String, Object> getRecord(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size) {
        return sysUserService.getRecord(size);
    }

    @GetMapping("/singleGetPaper")
    public List<RecordSingleGetPaper> singleGetPaper(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        return sysUserService.singleGetPaper(size);
    }

    @GetMapping("/singleSubmitScore")
    public List<RecordSingleSubmitScore> singleSubmitScore(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        return sysUserService.singleSubmitScore(size);
    }

    @GetMapping("/singleAll")
    public List<RecordSingleAll> singleAll(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        return sysUserService.singleAll(size);
    }

    @GetMapping("/unionGetPaper")
    public List<RecordUnionGetPaper> unionGetPaper(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        return sysUserService.unionGetPaper(size);
    }

    @GetMapping("/unionSubmitScore")
    public List<RecordUnionSubmitScore> unionSubmitScore(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        return sysUserService.unionSubmitScore(size);
    }

    @GetMapping("/unionAll")
    public List<RecordUnionAll> unionAll(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        return sysUserService.unionAll(size);
    }


}
