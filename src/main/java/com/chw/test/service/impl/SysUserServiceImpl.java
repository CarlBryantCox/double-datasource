package com.chw.test.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chw.test.dao.SysUserMapper;
import com.chw.test.entity.SysUser;
import com.chw.test.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-19
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getAllUser() {
        return sysUserMapper.getAllUser();
    }

    @Transactional(rollbackFor = Exception.class,transactionManager = "secondTransactionManager")
    @Override
    public String saveUser(Integer id) {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("test"+id);
        sysUser.setNickName("test"+id);
        //sysUser.setPhone("19900000000");
        sysUser.setPassword("123456");
        this.save(sysUser);
        Random random = new Random();
        int i = random.nextInt(3);
        System.out.println(3/(i-1));
        return "user";
    }
}
