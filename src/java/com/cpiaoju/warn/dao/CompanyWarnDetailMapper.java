package com.cpiaoju.warn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.warn.model.CompanyWarnDetail;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预警信息; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface CompanyWarnDetailMapper extends BaseMapper<CompanyWarnDetail> {


    List<CompanyWarnDetail> list(Map<String, Object> map);
}
