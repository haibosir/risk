package com.cpiaoju.warn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.warn.model.Feedback;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 反馈记录; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
public interface FeedbackService extends IService<Feedback> {

    List<Feedback> list(Map<String,Object> map);

}
