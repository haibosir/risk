package com.cpiaoju.personal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.personal.model.PersonalUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 个人用户; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface PersonalUserService extends IService<PersonalUser> {


    List<PersonalUser> listFull(@Param("page") PageParam page);

}
