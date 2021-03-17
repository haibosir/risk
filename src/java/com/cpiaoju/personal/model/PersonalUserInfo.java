package com.cpiaoju.personal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 个人用户基本信息; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_personal_user_info")
public class PersonalUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 个人用户id
     */
    private Long userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 婚姻状况
     */
    private Integer isMarriage;

    /**
     * 学历
     */
    private Integer isEducation;

    /**
     * 职称
     */
    private String post;

    /**
     * 近三年奖励
     */
    private String reward;

    /**
     * 工作年限
     */
    private String workYears;

    /**
     * 工商注册号
     */
    private String registrationNumber;

    /**
     * 纳税人识别号
     */
    private String identifier;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 行业分类
     */
    private Integer companyType;

    /**
     * 营业期限
     */
    private String businessTerm;

    /**
     * 人员数量
     */
    private String staffs;

    /**
     * 准入时间
     */
    private LocalDateTime admitTime;

    /**
     * 公司地址
     */
    private String companyAddress;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
    public Integer getIsMarriage() {
        return isMarriage;
    }

    public void setIsMarriage(Integer isMarriage) {
        this.isMarriage = isMarriage;
    }
    public Integer getIsEducation() {
        return isEducation;
    }

    public void setIsEducation(Integer isEducation) {
        this.isEducation = isEducation;
    }
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }
    public String getWorkYears() {
        return workYears;
    }

    public void setWorkYears(String workYears) {
        this.workYears = workYears;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }
    public String getBusinessTerm() {
        return businessTerm;
    }

    public void setBusinessTerm(String businessTerm) {
        this.businessTerm = businessTerm;
    }
    public String getStaffs() {
        return staffs;
    }

    public void setStaffs(String staffs) {
        this.staffs = staffs;
    }
    public LocalDateTime getAdmitTime() {
        return admitTime;
    }

    public void setAdmitTime(LocalDateTime admitTime) {
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
        return "PersonalUserInfo{" +
            "id=" + id +
            ", userId=" + userId +
            ", name=" + name +
            ", phone=" + phone +
            ", idNo=" + idNo +
            ", isMarriage=" + isMarriage +
            ", isEducation=" + isEducation +
            ", post=" + post +
            ", reward=" + reward +
            ", workYears=" + workYears +
            ", registrationNumber=" + registrationNumber +
            ", identifier=" + identifier +
            ", industry=" + industry +
            ", companyType=" + companyType +
            ", businessTerm=" + businessTerm +
            ", staffs=" + staffs +
            ", admitTime=" + admitTime +
            ", companyAddress=" + companyAddress +
        "}";
    }
}
