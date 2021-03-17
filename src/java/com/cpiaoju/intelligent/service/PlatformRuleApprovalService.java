package com.cpiaoju.intelligent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.intelligent.model.Channel;
import com.cpiaoju.intelligent.model.PlatformRuleApproval;
import com.cpiaoju.intelligent.model.PlatformRuleDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 规则审核日志; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface PlatformRuleApprovalService extends IService<PlatformRuleApproval> {


    List<PlatformRuleApproval> list(Map<String, Object> map);

    int count(Map<String, Object> map);

}
