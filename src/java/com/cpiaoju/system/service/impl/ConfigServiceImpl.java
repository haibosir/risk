package com.cpiaoju.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.system.dao.ConfigMapper;
import com.cpiaoju.system.model.Config;
import com.cpiaoju.system.service.ConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置; InnoDB free: 8192 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-03
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}
