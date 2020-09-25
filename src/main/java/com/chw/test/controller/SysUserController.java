package com.chw.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chw.test.entity.*;
import com.chw.test.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
    private MonitorSingleGetPaperService monitorSingleGetPaperService;

    @Resource
    private MonitorSingleSubmitScoreService monitorSingleSubmitScoreService;

    @Resource
    private MonitorUnionGetPaperService monitorUnionGetPaperService;

    @Resource
    private MonitorUnionSubmitScoreService monitorUnionSubmitScoreService;

    @Resource
    private RecordUnionGetPaperService recordUnionGetPaperService;

    @Resource
    private RecordSingleGetPaperService recordSingleGetPaperService;

    @Resource
    private RecordUnionSubmitScoreService recordUnionSubmitScoreService;

    @Resource
    private RecordSingleSubmitScoreService recordSingleSubmitScoreService;

    @GetMapping("/singleGetPaper")
    public List<RecordSingleGetPaper> singleGetPaper(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        List<RecordSingleGetPaper> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorSingleGetPaper> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorSingleGetPaper> list = monitorSingleGetPaperService.list(queryWrapper);
        if(!list.isEmpty()){
            for (int i = 0; i < list.size()-1; i++) {
                MonitorSingleGetPaper newRecord = list.get(i);
                MonitorSingleGetPaper oldRecord = list.get(i+1);
                RecordSingleGetPaper recordSingleGetPaper = new RecordSingleGetPaper();
                Duration between = Duration.between(oldRecord.getCreateTime(),newRecord.getCreateTime());
                recordSingleGetPaper.setSeconds((int) (between.toMillis()/1000));
                recordSingleGetPaper.setCreatTime(newRecord.getCreateTime());
                recordSingleGetPaper.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordSingleGetPaper.setGetTime(newRecord.getRequestTimeMillis()-oldRecord.getRequestTimeMillis());
                recordSingleGetPaper.setAvgGetTime(recordSingleGetPaper.getGetCount()==0?0:recordSingleGetPaper.getGetTime()/recordSingleGetPaper.getGetCount());
                recordSingleGetPaper.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordSingleGetPaper.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordSingleGetPaper.setAvgJdbcGetTime(recordSingleGetPaper.getGetJdbcCount()==0?0:recordSingleGetPaper.getGetJdbcTime()/recordSingleGetPaper.getGetJdbcCount());
                countRecordList.add(recordSingleGetPaper);
            }
            recordSingleGetPaperService.saveBatch(countRecordList);
        }
        return countRecordList;
    }

    @GetMapping("/singleSubmitScore")
    public List<RecordSingleSubmitScore> singleSubmitScore(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        List<RecordSingleSubmitScore> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorSingleSubmitScore> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorSingleSubmitScore> list = monitorSingleSubmitScoreService.list(queryWrapper);
        if(!list.isEmpty()){
            for (int i = 0; i < list.size()-1; i++) {
                MonitorSingleSubmitScore newRecord = list.get(i);
                MonitorSingleSubmitScore oldRecord = list.get(i+1);
                RecordSingleSubmitScore recordSingleSubmitScore = new RecordSingleSubmitScore();
                Duration between = Duration.between(oldRecord.getCreateTime(),newRecord.getCreateTime());
                recordSingleSubmitScore.setSeconds((int) (between.toMillis()/1000));
                recordSingleSubmitScore.setCreatTime(newRecord.getCreateTime());
                recordSingleSubmitScore.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordSingleSubmitScore.setGetTime(newRecord.getRequestTimeMillis()-oldRecord.getRequestTimeMillis());
                recordSingleSubmitScore.setAvgGetTime(recordSingleSubmitScore.getGetCount()==0?0:recordSingleSubmitScore.getGetTime()/recordSingleSubmitScore.getGetCount());
                recordSingleSubmitScore.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordSingleSubmitScore.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordSingleSubmitScore.setAvgJdbcGetTime(recordSingleSubmitScore.getGetJdbcCount()==0?0:recordSingleSubmitScore.getGetJdbcTime()/recordSingleSubmitScore.getGetJdbcCount());
                countRecordList.add(recordSingleSubmitScore);
            }
            recordSingleSubmitScoreService.saveBatch(countRecordList);
        }
        return countRecordList;
    }

    @GetMapping("/unionGetPaper")
    public List<RecordUnionGetPaper> unionGetPaper(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        List<RecordUnionGetPaper> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorUnionGetPaper> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorUnionGetPaper> list = monitorUnionGetPaperService.list(queryWrapper);
        if(!list.isEmpty()){
            for (int i = 0; i < list.size()-1; i++) {
                MonitorUnionGetPaper newRecord = list.get(i);
                MonitorUnionGetPaper oldRecord = list.get(i+1);
                RecordUnionGetPaper recordUnionGetPaper = new RecordUnionGetPaper();
                Duration between = Duration.between(oldRecord.getCreateTime(),newRecord.getCreateTime());
                recordUnionGetPaper.setSeconds((int) (between.toMillis()/1000));
                recordUnionGetPaper.setCreatTime(newRecord.getCreateTime());
                recordUnionGetPaper.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordUnionGetPaper.setGetTime(newRecord.getRequestTimeMillis()-oldRecord.getRequestTimeMillis());
                recordUnionGetPaper.setAvgGetTime(recordUnionGetPaper.getGetCount()==0?0:recordUnionGetPaper.getGetTime()/recordUnionGetPaper.getGetCount());
                recordUnionGetPaper.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordUnionGetPaper.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordUnionGetPaper.setAvgJdbcGetTime(recordUnionGetPaper.getGetJdbcCount()==0?0:recordUnionGetPaper.getGetJdbcTime()/recordUnionGetPaper.getGetJdbcCount());
                countRecordList.add(recordUnionGetPaper);
            }
            recordUnionGetPaperService.saveBatch(countRecordList);
        }
        return countRecordList;
    }

    @GetMapping("/unionSubmitScore")
    public List<RecordUnionSubmitScore> unionSubmitScore(@RequestParam(value = "size",required = false,defaultValue = "20") Integer size){
        List<RecordUnionSubmitScore> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorUnionSubmitScore> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorUnionSubmitScore> list = monitorUnionSubmitScoreService.list(queryWrapper);
        if(!list.isEmpty()){
            for (int i = 0; i < list.size()-1; i++) {
                MonitorUnionSubmitScore newRecord = list.get(i);
                MonitorUnionSubmitScore oldRecord = list.get(i+1);
                RecordUnionSubmitScore recordUnionSubmitScore = new RecordUnionSubmitScore();
                Duration between = Duration.between(newRecord.getCreateTime(), oldRecord.getCreateTime());
                recordUnionSubmitScore.setSeconds((int) (between.toMillis()/1000));
                recordUnionSubmitScore.setCreatTime(newRecord.getCreateTime());
                recordUnionSubmitScore.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordUnionSubmitScore.setGetTime(newRecord.getRequestTimeMillis()-oldRecord.getRequestTimeMillis());
                recordUnionSubmitScore.setAvgGetTime(recordUnionSubmitScore.getGetCount()==0?0:recordUnionSubmitScore.getGetTime()/recordUnionSubmitScore.getGetCount());
                recordUnionSubmitScore.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordUnionSubmitScore.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordUnionSubmitScore.setAvgJdbcGetTime(recordUnionSubmitScore.getGetJdbcCount()==0?0:recordUnionSubmitScore.getGetJdbcTime()/recordUnionSubmitScore.getGetJdbcCount());
                countRecordList.add(recordUnionSubmitScore);
            }
            recordUnionSubmitScoreService.saveBatch(countRecordList);
        }
        return countRecordList;
    }


}
