package com.cpiaoju.intelligent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.intelligent.model.PlatformRuleDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台规则-详情; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface PlatformRuleDetailService extends IService<PlatformRuleDetail> {

    List<PlatformRuleDetail> listFull(@Param("ids") List<Long> ids);

    int batchRemove(@Param("id") Long id);
}
