package com.cpiaoju.warn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.warn.model.CompanyInspection;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业巡查; InnoDB free: 8192 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2021-01-18
 */
public interface CompanyInspectionService extends IService<CompanyInspection> {


    List<CompanyInspection> list(Map<String,Object> map);

    int count(Map<String,Object> map);
}
