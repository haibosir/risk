package com.cpiaoju.system.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.system.model.RoleAuthorities;

import java.util.List;

/**
 * <p>
 * 角色权限关联表 服务类
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface RoleAuthoritiesService extends IService<RoleAuthorities> {
    boolean updateRoleAuth(Integer roleId, List<Integer> authIds);
}
