package com.cpiaoju.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.common.utils.StringUtil;
import com.cpiaoju.system.dao.LoginRecordMapper;
import com.cpiaoju.system.dao.UserPlatformMapper;
import com.cpiaoju.system.model.LoginRecord;
import com.cpiaoju.system.model.User;
import com.cpiaoju.system.model.UserPlatform;
import com.cpiaoju.system.model.UserRole;
import com.cpiaoju.system.service.LoginRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
@Service
public class LoginRecordServiceImpl extends ServiceImpl<LoginRecordMapper, LoginRecord> implements LoginRecordService {

    @Autowired
    private UserPlatformMapper userPlatformMapper;

    @Override
    public PageResult<LoginRecord> listFull(PageParam pageParam) {
        List<LoginRecord> records = baseMapper.listFull(pageParam);
        if (records != null && records.size() > 0) {
            List<UserPlatform> platformList = userPlatformMapper.findPlatformNameByUserId(getUserIds(records));
            StringBuilder sb = new StringBuilder();
            for (LoginRecord one : records) {
                sb.setLength(0);
                platformList.stream().forEach(platform->{
                    if(platform.getUserId().equals(one.getUserId())){
                        if(!StringUtil.isBlank(platform.getPlatformName())){
                            if(sb.length() != 0){
                                sb.append(","+platform.getPlatformName());
                            }else{
                                sb.append(platform.getPlatformName());
                            }
                        }
                    }
                });
                one.setPlatformNames(sb.toString());
            }
        }

        return new PageResult<>(records, pageParam.getTotal());
    }

    /**
     * 获取用户id
     */
    private List<Integer> getUserIds(List<LoginRecord> recordList) {
        List<Integer> userIds = new ArrayList<>();
        for (LoginRecord one : recordList) {
            userIds.add(one.getUserId());
        }
        return userIds;
    }
}
