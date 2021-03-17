package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 企业信息; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 来源
     */
    private Integer target;


    /**
     * 来源名称
     */
    @TableField(exist = false)
    private String targetName;

    /**
     * 评级名称
     */
    private Integer grade;

    private Integer platformId;

    /**
     * 评级名称
     */
    @TableField(exist = false)
    private String gradeName;

    /**
     * 企业性质
     */
    private Integer companyNature;

    @TableField(exist = false)
    private String companyNatureName;


    /**
     * 准入时间
     */
    private Date inTime;

    /**
     * 违规原因
     */
    private String violationsReasons;

    /**
     * 0白名单1黑名单
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private Integer productCount;

    private Integer companyType;
    /**
     * 企业类型名称
     */
    @TableField(exist = false)
    private String companyTypeName;

    private String legalName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    public Integer getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(Integer companyNature) {
        this.companyNature = companyNature;
    }
    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
    public String getViolationsReasons() {
        return violationsReasons;
    }

    public void setViolationsReasons(String violationsReasons) {
        this.violationsReasons = violationsReasons;
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
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getCompanyNatureName() {
        return companyNatureName;
    }

    public void setCompanyNatureName(String companyNatureName) {
        this.companyNatureName = companyNatureName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    @Override
    public String toString() {
        return "Company{" +
            "id=" + id +
            ", companyName=" + companyName +
            ", target=" + target +
            ", grade=" + grade +
            ", companyNature=" + companyNature +
            ", inTime=" + inTime +
            ", violationsReasons=" + violationsReasons +
            ", status=" + status +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
