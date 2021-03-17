package com.cpiaoju.intelligent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.intelligent.model.PlatformRule;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台规则; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface PlatformRuleService extends IService<PlatformRule> {

    List<PlatformRule> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
