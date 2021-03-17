package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 企业执照信息; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_license")
public class CompanyLicense implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 企业id
     */
    private Long companyId;

    /**
     * 法人代表人
     */
    private String legalName;

    /**
     * 经营状态
     */
    private Integer status;

    /**
     * 成立时间
     */
    private Date createTime;

    /**
     * 注册资本
     */
    private String registeredCapital;

    /**
     * 实缴资本
     */
    private String payCapital;

    /**
     * 核准时间
     */
    private Date checkTime;

    /**
     * 统一信用代码
     */
    private String creditCode;

    /**
     * 组织结构代码
     */
    private String organizationCode;

    /**
     * 工商注册号
     */
    private String registrationNumber;

    /**
     * 纳税人识别号
     */
    private String identificationNumber;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 企业类型
     */
    private String companyType;

    /**
     * 营业期限
     */
    private String businessTerm;

    /**
     * 人员规模
     */
    private String employees;

    /**
     * 准入时间
     */
    private Date admitTime;

    /**
     * 企业地址
     */
    private String companyAddress;

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
    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }
    public String getPayCapital() {
        return payCapital;
    }

    public void setPayCapital(String payCapital) {
        this.payCapital = payCapital;
    }
    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }
    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumbe) {
        this.identificationNumber = identificationNumber;
    }
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
    public String getBusinessTerm() {
        return businessTerm;
    }

    public void setBusinessTerm(String businessTerm) {
        this.businessTerm = businessTerm;
    }
    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }
    public Date getAdmitTime() {
        return admitTime;
    }

    public void setAdmitTime(Date admitTime) {
        this.admitTime = admitTime;
    }
    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {
        return "CompanyLicense{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", legalName=" + legalName +
            ", status=" + status +
            ", createTime=" + createTime +
            ", registeredCapital=" + registeredCapital +
            ", payCapital=" + payCapital +
            ", checkTime=" + checkTime +
            ", creditCode=" + creditCode +
            ", organizationCode=" + organizationCode +
            ", registrationNumber=" + registrationNumber +
            ", identificationNumber=" + identificationNumber +
            ", industry=" + industry +
            ", companyType=" + companyType +
            ", businessTerm=" + businessTerm +
            ", employees=" + employees +
            ", admitTime=" + admitTime +
            ", companyAddress=" + companyAddress +
        "}";
    }
}
