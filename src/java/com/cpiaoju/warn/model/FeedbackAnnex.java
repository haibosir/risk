package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 反馈文件; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
@TableName("sys_feedback_annex")
public class FeedbackAnnex implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 反馈id
     */
    private Long feedId;

    /**
     * 附件名称
     */
    private String annexName;

    /**
     * 附件地址
     */
    private String annex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getFeedId() {
        return feedId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
    }
    public String getAnnexName() {
        return annexName;
    }

    public void setAnnexName(String annexName) {
        this.annexName = annexName;
    }
    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    @Override
    public String toString() {
        return "FeedbackAnnex{" +
            "id=" + id +
            ", feedId=" + feedId +
            ", annexName=" + annexName +
            ", annex=" + annex +
        "}";
    }
}
