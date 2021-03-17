package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 最终受益人; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_beneficiary")
public class CompanyBeneficiary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long companyId;

    /**
     * 受益人名称
     */
    private String userName;

    /**
     * 持股比例
     */
    private String shareholdingRatio;

    /**
     * 股权链
     */
    private String equityChain;

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
    public String getShareholdingRatio() {
        return shareholdingRatio;
    }

    public void setShareholdingRatio(String shareholdingRatio) {
        this.shareholdingRatio = shareholdingRatio;
    }
    public String getEquityChain() {
        return equityChain;
    }

    public void setEquityChain(String equityChain) {
        this.equityChain = equityChain;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CompanyBeneficiary{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", userName=" + userName +
            ", shareholdingRatio=" + shareholdingRatio +
            ", equityChain=" + equityChain +
            ", createTime=" + createTime +
        "}";
    }
}
