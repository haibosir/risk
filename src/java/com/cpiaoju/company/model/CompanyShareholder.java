package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 股东信息; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_shareholder")
public class CompanyShareholder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 企业id
     */
    private Long companyId;

    /**
     * 股东及出资信息
     */
    private String shareholderInfo;

    /**
     * 持股比例
     */
    private String shareholdingRatio;

    /**
     * 认缴资金
     */
    private String payCapital;

    /**
     * 认缴日期
     */
    private Date payTime;

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
    public String getShareholderInfo() {
        return shareholderInfo;
    }

    public void setShareholderInfo(String shareholderInfo) {
        this.shareholderInfo = shareholderInfo;
    }
    public String getShareholdingRatio() {
        return shareholdingRatio;
    }

    public void setShareholdingRatio(String shareholdingRatio) {
        this.shareholdingRatio = shareholdingRatio;
    }
    public String getPayCapital() {
        return payCapital;
    }

    public void setPayCapital(String payCapital) {
        this.payCapital = payCapital;
    }
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "CompanyShareholder{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", shareholderInfo=" + shareholderInfo +
            ", shareholdingRatio=" + shareholdingRatio +
            ", payCapital=" + payCapital +
            ", payTime=" + payTime +
        "}";
    }
}
