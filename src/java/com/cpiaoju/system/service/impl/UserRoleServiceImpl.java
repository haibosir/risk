package com.cpiaoju.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.system.dao.UserRoleMapper;
import com.cpiaoju.system.model.UserRole;
import com.cpiaoju.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public List<UserRole> findUserRoleByUserId(Integer userId){

        return baseMapper.findUserRoleByUserId(userId);
    }



}
