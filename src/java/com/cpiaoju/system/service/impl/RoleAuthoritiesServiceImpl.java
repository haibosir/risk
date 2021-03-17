package com.cpiaoju.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.exception.BusinessException;
import com.cpiaoju.system.dao.RoleAuthoritiesMapper;
import com.cpiaoju.system.model.RoleAuthorities;
import com.cpiaoju.system.service.RoleAuthoritiesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
@Service
public class RoleAuthoritiesServiceImpl extends ServiceImpl<RoleAuthoritiesMapper, RoleAuthorities> implements RoleAuthoritiesService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateRoleAuth(Integer roleId, List<Integer> authIds) {
        baseMapper.delete(new UpdateWrapper<RoleAuthorities>().eq("role_id", roleId));
        if (authIds != null && authIds.size() > 0) {
            if (baseMapper.insertRoleAuths(roleId, authIds) < authIds.size()) {
                throw new BusinessException("操作失败");
            }
        }
        return true;
    }

}
