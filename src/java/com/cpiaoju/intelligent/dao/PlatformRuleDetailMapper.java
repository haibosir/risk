package com.cpiaoju.intelligent.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.intelligent.model.PlatformRuleDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 平台规则-详情; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface PlatformRuleDetailMapper extends BaseMapper<PlatformRuleDetail> {

    List<PlatformRuleDetail> listFull(@Param("ids") List<Long> ids);

    int batchRemove(@Param("id") Long id);
}
