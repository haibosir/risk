package com.cpiaoju.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.exception.BusinessException;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.system.dao.UserMapper;
import com.cpiaoju.system.dao.UserPlatformMapper;
import com.cpiaoju.system.dao.UserRoleMapper;
import com.cpiaoju.system.model.User;
import com.cpiaoju.system.model.UserPlatform;
import com.cpiaoju.system.model.UserRole;
import com.cpiaoju.system.service.UserService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户表 服务实现类
 *
 * @author huhb
 * @since 2019-02-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserPlatformMapper userPlatformMapper;

    @Override
    public User getByUsername(String username) {
        return baseMapper.selectByUsername(username);
    }

    @Override
    public PageResult<User> listUser(PageParam pageParam) {
        List<User> userList = baseMapper.listFull(pageParam);
        // 查询user的角色
        if (userList != null && userList.size() > 0) {
            List<UserRole> userRoles = userRoleMapper.selectByUserIds(getUserIds(userList));
            List<UserPlatform> platformList = userPlatformMapper.findPlatformNameByUserId(getUserIds(userList));
            StringBuilder sb = new StringBuilder();
            StringBuilder role = new StringBuilder();
            for (User one : userList) {
                role.setLength(0);
                userRoles.stream().forEach(tempRole->{
                    if(one.getUserId().equals(tempRole.getUserId())){
                        if(!StringUtil.isBlank(tempRole.getRoleName())){
                            if(role.length() == 0){
                                role.append(tempRole.getRoleName());
                            }else{
                                role.append(","+tempRole.getRoleName());
                            }
                        }
                    }
                });
                sb.setLength(0);
                platformList.stream().forEach(platform->{
                    if(platform.getUserId().equals(one.getUserId())){
                        if(!StringUtil.isBlank(platform.getPlatformName())){
                            if(sb.length() == 0){
                                sb.append(platform.getPlatformName());
                            }else{
                                sb.append(","+platform.getPlatformName());
                            }
                        }
                    }
                });
                one.setPlatformNames(sb.toString());
                one.setRoleNames(role!=null?role.toString():"");
            }
        }
        return new PageResult<>(userList, pageParam.getTotal());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUser(User user, List<Integer> roleIds,List<Integer> platformIds) {
        if (baseMapper.selectByUsername(user.getUsername()) != null) {
            throw new BusinessException("账号已经存在");
        }
        boolean result = baseMapper.insert(user) > 0;
        if (result) {
            if (userRoleMapper.insertBatch(user.getUserId(), roleIds) < roleIds.size()) {
                throw new BusinessException("添加失败");
            }
            if (userPlatformMapper.insertBatch(user.getUserId(), platformIds) < platformIds.size()) {
                throw new BusinessException("添加失败");
            }
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUser(User user, List<Integer> roleIds,List<Integer> platformIds) {
        user.setUsername(null);  // 账号不能修改
        boolean result = baseMapper.updateById(user) > 0;
        if (result && !CollectionUtils.isEmpty(roleIds)) {
            userRoleMapper.delete(new UpdateWrapper<UserRole>().eq("user_id", user.getUserId()));

            userPlatformMapper.delete(new UpdateWrapper<UserPlatform>().eq("user_id", user.getUserId()));

            if (userRoleMapper.insertBatch(user.getUserId(), roleIds) < roleIds.size()) {
                throw new BusinessException("修改失败");
            }
            if (userPlatformMapper.insertBatch(user.getUserId(), platformIds) < platformIds.size()) {
                throw new BusinessException("添加失败");
            }
        }
        return result;
    }

    /**
     * 获取用户id
     */
    private List<Integer> getUserIds(List<User> userList) {
        List<Integer> userIds = new ArrayList<>();
        for (User one : userList) {
            userIds.add(one.getUserId());
        }
        return userIds;
    }

    @Override
    public List<User> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }
}
