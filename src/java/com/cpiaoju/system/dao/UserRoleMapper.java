package com.cpiaoju.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.system.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<UserRole> selectByUserIds(@Param("userIds") List<Integer> userIds);

    int insertBatch(@Param("userId") Integer userId, @Param("roleIds") List<Integer> roleIds);

    List<UserRole> findUserRoleByUserId(Integer userId);
}
