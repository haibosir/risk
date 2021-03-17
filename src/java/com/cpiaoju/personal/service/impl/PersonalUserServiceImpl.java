package com.cpiaoju.personal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.personal.dao.PersonalUserMapper;
import com.cpiaoju.personal.model.PersonalUser;
import com.cpiaoju.personal.service.PersonalUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人用户; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class PersonalUserServiceImpl extends ServiceImpl<PersonalUserMapper, PersonalUser> implements PersonalUserService {

    @Override
    public List<PersonalUser> listFull(PageParam page) {
        return baseMapper.listFull(page);
    }
}
