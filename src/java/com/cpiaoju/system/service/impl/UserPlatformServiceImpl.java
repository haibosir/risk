package com.cpiaoju.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.system.dao.UserPlatformMapper;
import com.cpiaoju.system.model.UserPlatform;
import com.cpiaoju.system.service.UserPlatformService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户平台关联表; InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-11-25
 */
@Service
public class UserPlatformServiceImpl extends ServiceImpl<UserPlatformMapper, UserPlatform> implements UserPlatformService {


    @Override
    public List<UserPlatform> findPlatformNameByUserId(@Param("userIds") List<Integer> userIds){
        return baseMapper.findPlatformNameByUserId(userIds);
    }


}
