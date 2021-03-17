package com.cpiaoju.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.system.model.RoleAuthorities;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色权限关联表 Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface RoleAuthoritiesMapper extends BaseMapper<RoleAuthorities> {

    int insertRoleAuths(@Param("roleId") Integer roleId, @Param("authIds") List<Integer> authIds);

}
