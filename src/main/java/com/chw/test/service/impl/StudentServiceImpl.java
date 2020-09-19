package com.chw.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chw.test.entity.Student;
import com.chw.test.mapper.StudentMapper;
import com.chw.test.service.StudentService;
import com.chw.test.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-19
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    private SysUserService sysUserService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveStudent(Integer id) {
        Student student = new Student();
        student.setStudentName("student"+id);
        this.save(student);
        sysUserService.saveUser(id);
        Random random = new Random();
        int i = random.nextInt(3);
        System.out.println(2/(i-1));
        return "student";
    }
}
