package com.cpiaoju.warn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.warn.model.CompanyInspection;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业巡查; InnoDB free: 8192 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2021-01-18
 */
public interface CompanyInspectionMapper extends BaseMapper<CompanyInspection> {

    List<CompanyInspection> list(Map<String,Object> map);

    int count(Map<String,Object> map);
}
