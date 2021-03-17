package com.cpiaoju.personal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.personal.model.PersonalUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 个人用户; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface PersonalUserMapper extends BaseMapper<PersonalUser> {

    List<PersonalUser> listFull(@Param("page") PageParam page);
}
