package com.cpiaoju.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.system.model.Authorities;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface AuthoritiesMapper extends BaseMapper<Authorities> {

    List<Authorities> listByUserId(Integer userId);

    List<Authorities> listByRoleIds(@Param("roleIds") List<Integer> roleIds);

    List<Authorities> listByRoleId(Integer roleId);
}
