package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 预警记录(企业风险,发票风险,承兑风险); InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_warning_log")
public class CompanyWarningLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long companyId;

    @TableField(exist = false)
    private String companyName;

    /**
     * 预警编号
     */
    private String warningNo;

    /**
     * 预警对象名称
     */
    private String warningName;

    /**
     * 巡查间隔
     */
    private Integer space;

    /**
     * 预警等级
     */
    private Integer level;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 通知用户
     */
    @TableField(exist = false)
    private String noticer;

    @TableField(exist = false)
    private String companyTypeName;

    @TableField(exist = false)
    private Integer isBlack;

    @TableField(exist = false)
    private String spaceName;


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
    public String getWarningNo() {
        return warningNo;
    }

    public void setWarningNo(String warningNo) {
        this.warningNo = warningNo;
    }
    public String getWarningName() {
        return warningName;
    }

    public void setWarningName(String warningName) {
        this.warningName = warningName;
    }
    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public String getNoticer() {
        return noticer;
    }

    public void setNoticer(String noticer) {
        this.noticer = noticer;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    public Integer getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(Integer isBlack) {
        this.isBlack = isBlack;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    @Override
    public String toString() {
        return "CompanyWarningLog{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", warningNo=" + warningNo +
            ", warningName=" + warningName +
            ", space=" + space +
            ", level=" + level +
            ", createTime=" + createTime +
            ", status=" + status +
            ", updateTime=" + updateTime +
            ", noticer=" + noticer +
        "}";
    }
}
