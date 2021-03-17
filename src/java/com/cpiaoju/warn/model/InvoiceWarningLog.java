package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 发票预警信息; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
@TableName("sys_invoice_warning_log")
public class InvoiceWarningLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 预警编号
     */
    private String warnNo;

    /**
     * 预警对象
     */
    private String warningName;

    /**
     * 来源（平台信息）
     */
    private Long source;

    /**
     * 债务人
     */
    private String debtor;

    /**
     * 预警原因
     */
    private String warnReason;

    /**
     * 风险等级1初级2中级3高级
     */
    private Integer level;

    /**
     * 状态0未处理1已处理
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

    private Integer companyId;

    @TableField(exist = false)
    private String platformName;

    @TableField(exist = false)
    private String noticer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getWarnNo() {
        return warnNo;
    }

    public void setWarnNo(String warnNo) {
        this.warnNo = warnNo;
    }
    public String getWarningName() {
        return warningName;
    }

    public void setWarningName(String warningName) {
        this.warningName = warningName;
    }
    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }
    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }
    public String getWarnReason() {
        return warnReason;
    }

    public void setWarnReason(String warnReason) {
        this.warnReason = warnReason;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getNoticer() {
        return noticer;
    }

    public void setNoticer(String noticer) {
        this.noticer = noticer;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "InvoiceWarningLog{" +
            "id=" + id +
            ", warnNo=" + warnNo +
            ", warningName=" + warningName +
            ", source=" + source +
            ", debtor=" + debtor +
            ", warnReason=" + warnReason +
            ", level=" + level +
            ", status=" + status +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
