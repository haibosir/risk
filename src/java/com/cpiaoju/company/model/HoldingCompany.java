package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 持股企业; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_holding_company")
public class HoldingCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long companyId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 投资比例
     */
    private String investmentRatio;

    /**
     * 投资链
     */
    private String investmentChain;

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
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getInvestmentRatio() {
        return investmentRatio;
    }

    public void setInvestmentRatio(String investmentRatio) {
        this.investmentRatio = investmentRatio;
    }
    public String getInvestmentChain() {
        return investmentChain;
    }

    public void setInvestmentChain(String investmentChain) {
        this.investmentChain = investmentChain;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "HoldingCompany{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", companyName=" + companyName +
            ", investmentRatio=" + investmentRatio +
            ", investmentChain=" + investmentChain +
            ", createTime=" + createTime +
        "}";
    }
}
