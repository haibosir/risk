package com.cpiaoju.personal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 个人用户征信; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_personal_user_credit")
public class PersonalUserCredit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    /**
     * 授信额度
     */
    private String creditAmount;

    /**
     * 逾期次数
     */
    private Long count;

    /**
     * 逾期金额
     */
    private String beOverdueAmount;

    /**
     * 逾期类型
     */
    private String beOverdueType;

    /**
     * 手机号码状态
     */
    private Integer phoneStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    public String getBeOverdueAmount() {
        return beOverdueAmount;
    }

    public void setBeOverdueAmount(String beOverdueAmount) {
        this.beOverdueAmount = beOverdueAmount;
    }
    public String getBeOverdueType() {
        return beOverdueType;
    }

    public void setBeOverdueType(String beOverdueType) {
        this.beOverdueType = beOverdueType;
    }
    public Integer getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(Integer phoneStatus) {
        this.phoneStatus = phoneStatus;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PersonalUserCredit{" +
            "id=" + id +
            ", userId=" + userId +
            ", creditAmount=" + creditAmount +
            ", count=" + count +
            ", beOverdueAmount=" + beOverdueAmount +
            ", beOverdueType=" + beOverdueType +
            ", phoneStatus=" + phoneStatus +
            ", createTime=" + createTime +
        "}";
    }
}
