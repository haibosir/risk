package com.cpiaoju.intelligent.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 规则审核日志; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_platform_rule_approval")
public class PlatformRuleApproval implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 规则id
     */
    private Long ruleId;

    /**
     * 状态0成功1失败
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 审核人
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private String ruleNo;

    @TableField(exist = false)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PlatformRuleApproval{" +
            "id=" + id +
            ", ruleId=" + ruleId +
            ", status=" + status +
            ", remark=" + remark +
            ", createUser=" + createUser +
            ", createTime=" + createTime +
        "}";
    }
}
