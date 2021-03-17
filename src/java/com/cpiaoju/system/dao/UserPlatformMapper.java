package com.cpiaoju.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.system.model.UserPlatform;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户平台关联表; InnoDB free: 9216 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-11-25
 */
public interface UserPlatformMapper extends BaseMapper<UserPlatform> {

    List<UserPlatform> findPlatformNameByUserId(@Param("userIds") List<Integer> userIds);

    int insertBatch(@Param("userId") Integer userId, @Param("platformIds") List<Integer> platformIds);
}
