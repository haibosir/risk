package com.cpiaoju.company.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.company.model.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业信息; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface CompanyMapper extends BaseMapper<Company> {

    List<Company> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    Company get(Integer id);

}
