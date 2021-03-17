package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 预警信息; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_warn_detail")
public class CompanyWarnDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 指标id
     */
    private Long channelTargetId;

    /**
     * 状态0通过1命中
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 预警关联id
     */
    private Long warnId;

    @TableField(exist = false)
    private String targetName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getChannelTargetId() {
        return channelTargetId;
    }

    public void setChannelTargetId(Long channelTargetId) {
        this.channelTargetId = channelTargetId;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Long getWarnId() {
        return warnId;
    }

    public void setWarnId(Long warnId) {
        this.warnId = warnId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    @Override
    public String toString() {
        return "CompanyWarnDetail{" +
            "id=" + id +
            ", channelTargetId=" + channelTargetId +
            ", status=" + status +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", warnId=" + warnId +
        "}";
    }
}
