package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 对外投资; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_investment")
public class CompanyInvestment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联企业id
     */
    private Long companyId;

    /**
     * 投资企业名称
     */
    private String investmentCompanyName;

    /**
     * 法定代表
     */
    private String legalName;

    /**
     * 注册资本
     */
    private String registeredCapital;

    /**
     * 投资比例
     */
    private String investmentRatio;

    /**
     * 投资数额
     */
    private String investmentAmount;

    /**
     * 最终受益股份
     */
    private String beneficialShares;

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
    public String getInvestmentCompanyName() {
        return investmentCompanyName;
    }

    public void setInvestmentCompanyName(String investmentCompanyName) {
        this.investmentCompanyName = investmentCompanyName;
    }
    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }
    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }
    public String getInvestmentRatio() {
        return investmentRatio;
    }

    public void setInvestmentRatio(String investmentRatio) {
        this.investmentRatio = investmentRatio;
    }
    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }
    public String getBeneficialShares() {
        return beneficialShares;
    }

    public void setBeneficialShares(String beneficialShares) {
        this.beneficialShares = beneficialShares;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CompanyInvestment{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", investmentCompanyName=" + investmentCompanyName +
            ", legalName=" + legalName +
            ", registeredCapital=" + registeredCapital +
            ", investmentRatio=" + investmentRatio +
            ", investmentAmount=" + investmentAmount +
            ", beneficialShares=" + beneficialShares +
            ", createTime=" + createTime +
        "}";
    }
}
