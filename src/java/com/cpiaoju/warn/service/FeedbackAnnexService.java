package com.cpiaoju.warn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.warn.model.FeedbackAnnex;

import java.util.List;

/**
 * <p>
 * 反馈文件; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhbs
 * @since 2021-01-04
 */
public interface FeedbackAnnexService extends IService<FeedbackAnnex> {

    List<FeedbackAnnex> list(Integer feedId);
}
