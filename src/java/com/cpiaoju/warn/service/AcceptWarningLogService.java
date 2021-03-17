package com.cpiaoju.warn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.warn.model.AcceptWarningLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 风险预警-承兑提示; InnoDB free: 8192 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2021-01-05
 */
public interface AcceptWarningLogService extends IService<AcceptWarningLog> {


    List<AcceptWarningLog> list(Map<String,Object> map);

    int count(Map<String,Object> map);
}
