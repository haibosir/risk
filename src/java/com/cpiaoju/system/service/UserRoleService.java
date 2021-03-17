package com.cpiaoju.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.system.model.UserRole;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface UserRoleService extends IService<UserRole> {

    List<UserRole> findUserRoleByUserId(Integer userId);

}
