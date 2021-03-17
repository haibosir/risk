package com.cpiaoju.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.system.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByUsername(String username);

    List<User> listFull(@Param("page") PageParam page);

    List<User> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
