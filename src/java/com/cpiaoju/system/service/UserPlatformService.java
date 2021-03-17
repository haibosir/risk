package com.cpiaoju.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.system.model.UserPlatform;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户平台关联表; InnoDB free: 9216 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-11-25
 */
public interface UserPlatformService extends IService<UserPlatform> {


    List<UserPlatform> findPlatformNameByUserId(@Param("userIds") List<Integer> userIds);

}
