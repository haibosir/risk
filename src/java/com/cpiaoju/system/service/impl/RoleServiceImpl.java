package com.cpiaoju.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.system.dao.RoleMapper;
import com.cpiaoju.system.model.Role;
import com.cpiaoju.system.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
