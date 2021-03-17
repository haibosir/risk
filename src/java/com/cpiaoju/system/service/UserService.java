package com.cpiaoju.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.system.model.User;
import java.util.List;
import java.util.Map;

/**
 * 用户表 服务类
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface UserService extends IService<User> {

    User getByUsername(String username);

    PageResult<User> listUser(PageParam pageParam);

    boolean addUser(User user, List<Integer> roleIds,List<Integer> platformIds);

    boolean updateUser(User user, List<Integer> roleIds,List<Integer> platformIds);

    List<User> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
