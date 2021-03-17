package com.cpiaoju.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.system.model.Authorities;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface AuthoritiesService extends IService<Authorities> {

    List<Authorities> listByUserId(Integer userId);

    List<Authorities> listByRoleIds(@Param("roleIds") List<Integer> roleIds);

    List<Authorities> listByRoleId(Integer roleId);
}
