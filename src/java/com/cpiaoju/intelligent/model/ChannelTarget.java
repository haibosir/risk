package com.cpiaoju.intelligent.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 指标; InnoDB free: 9216 kB
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
@TableName("sys_channel_target")
public class ChannelTarget implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 指标名称
     */
    private String targetName;

    private String targetNo;

    private Integer channelId;


    /**
     * 一级指标分类
     */
    private Integer parentTargetId;


    /**
     * 二级指标类型
     */
    private Integer targetId;

    /**
     * 指标格式
     */
    private String targetFormat;

    /**
     * 指标属性1文本指标2数值指标
     */
    private Integer targetAttribute;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 0有效1无效
     */
    private Integer status;

    private Integer userdCount;

    @TableField(exist = false)
    private String channelName;

    @TableField(exist = false)
    private String parentIds;

    @TableField(exist = false)
    private String parentTargetName;

    @TableField(exist = false)
    private String dictTargetName;

    @TableField(exist = false)
    private Integer type;

    @TableField(exist = false)
    private String targetAttributeName;

    @TableField(exist = false)
    private String content;

    @TableField(exist = false)
    private Integer operator;

    @TableField(exist = false)
    private Long ruleDetailId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
    public Integer getParentTargetId() {
        return parentTargetId;
    }

    public void setParentTargetId(Integer parentTargetId) {
        this.parentTargetId = parentTargetId;
    }
    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }
    public String getTargetFormat() {
        return targetFormat;
    }

    public void setTargetFormat(String targetFormat) {
        this.targetFormat = targetFormat;
    }
    public Integer getTargetAttribute() {
        return targetAttribute;
    }

    public void setTargetAttribute(Integer targetAttribute) {
        this.targetAttribute = targetAttribute;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTargetNo() {
        return targetNo;
    }

    public void setTargetNo(String targetNo) {
        this.targetNo = targetNo;
    }

    public Integer getUserdCount() {
        return userdCount;
    }

    public void setUserdCount(Integer userdCount) {
        this.userdCount = userdCount;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getParentTargetName() {
        return parentTargetName;
    }

    public void setParentTargetName(String parentTargetName) {
        this.parentTargetName = parentTargetName;
    }

    public String getDictTargetName() {
        return dictTargetName;
    }

    public void setDictTargetName(String dictTargetName) {
        this.dictTargetName = dictTargetName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTargetAttributeName() {
        return targetAttributeName;
    }

    public void setTargetAttributeName(String targetAttributeName) {
        this.targetAttributeName = targetAttributeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getRuleDetailId() {
        return ruleDetailId;
    }

    public void setRuleDetailId(Long ruleDetailId) {
        this.ruleDetailId = ruleDetailId;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "ChannelTarget{" +
            "id=" + id +
            ", targetNo=" + targetNo +
            ", targetName=" + targetName +
            ", channelId=" + channelId +
            ", parentTargetId=" + parentTargetId +
            ", targetId=" + targetId +
            ", targetFormat=" + targetFormat +
            ", targetAttribute=" + targetAttribute +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", status=" + status +
            ", userdCount=" + userdCount +
        "}";
    }
}
