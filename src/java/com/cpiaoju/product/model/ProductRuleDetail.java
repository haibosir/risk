package com.cpiaoju.product.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 平台规则-详情; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_product_rule_detail")
public class ProductRuleDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 1平台准入2货前验证3货前评分4时点审核
     */
    private Integer type;

    /**
     * 产品规则id
     */
    private Long ruleId;

    /**
     * 一级指标分类
     */
    private Long parentTargetId;

    /**
     * 二级分类
     */
    private Long targetId;

    /**
     * 指标id
     */
    private Long channelTargetId;

    /**
     * 操作符
     */
    private Integer operator;

    /**
     * 匹配内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除0正常1删除
     */
    private Integer status;

    /**
     * 最高分
     */
    private String highScore;

    @TableField(exist = false)
    private Integer userdCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
    public Long getParentTargetId() {
        return parentTargetId;
    }

    public void setParentTargetId(Long parentTargetId) {
        this.parentTargetId = parentTargetId;
    }
    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
    public Long getChannelTargetId() {
        return channelTargetId;
    }

    public void setChannelTargetId(Long channelTargetId) {
        this.channelTargetId = channelTargetId;
    }
    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }

    public Integer getUserdCount() {
        return userdCount;
    }

    public void setUserdCount(Integer userdCount) {
        this.userdCount = userdCount;
    }

    @Override
    public String toString() {
        return "ProductRuleDetail{" +
            "id=" + id +
            ", type=" + type +
            ", ruleId=" + ruleId +
            ", parentTargetId=" + parentTargetId +
            ", targetId=" + targetId +
            ", channelTargetId=" + channelTargetId +
            ", operator=" + operator +
            ", content=" + content +
            ", createTime=" + createTime +
            ", status=" + status +
            ", highScore=" + highScore +
        "}";
    }
}
