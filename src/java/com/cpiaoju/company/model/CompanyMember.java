package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 企业人员; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_member")
public class CompanyMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long companyId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 职务
     */
    private String post;

    /**
     * 持股比例
     */
    private String shareholdingRatio;

    /**
     * 受益股份
     */
    private String benefitShares;

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
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    public String getShareholdingRatio() {
        return shareholdingRatio;
    }

    public void setShareholdingRatio(String shareholdingRatio) {
        this.shareholdingRatio = shareholdingRatio;
    }
    public String getBenefitShares() {
        return benefitShares;
    }

    public void setBenefitShares(String benefitShares) {
        this.benefitShares = benefitShares;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CompanyMember{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", userName=" + userName +
            ", post=" + post +
            ", shareholdingRatio=" + shareholdingRatio +
            ", benefitShares=" + benefitShares +
            ", createTime=" + createTime +
        "}";
    }
}
