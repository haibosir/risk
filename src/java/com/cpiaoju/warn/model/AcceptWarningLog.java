package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 风险预警-承兑提示; InnoDB free: 8192 kB
 * </p>
 *
 * @author huhb
 * @since 2021-01-05
 */
@TableName("sys_accept_warning_log")
public class AcceptWarningLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 逾期编号
     */
    private String beOverdueNo;

    private Integer orderId;

    @TableField(exist = false)
    private String orderNo;

    /**
     * 预警对象
     */
    private String warnName;

    /**
     * 来源(平台)
     */
    private Long source;

    /**
     * 承兑人
     */
    private String acceptor;

    /**
     * 票面金额
     */
    private String financeAmount;

    /**
     * 到期日
     */
    private LocalDateTime endTime;

    /**
     * 0未处理1已处理
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private Integer companyId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

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
    public String getBeOverdueNo() {
        return beOverdueNo;
    }

    public void setBeOverdueNo(String beOverdueNo) {
        this.beOverdueNo = beOverdueNo;
    }
    public String getWarnName() {
        return warnName;
    }

    public void setWarnName(String warnName) {
        this.warnName = warnName;
    }
    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }
    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }
    public String getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(String financeAmount) {
        this.financeAmount = financeAmount;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
        return "AcceptWarningLog{" +
            "id=" + id +
            ", beOverdueNo=" + beOverdueNo +
            ", warnName=" + warnName +
            ", source=" + source +
            ", acceptor=" + acceptor +
            ", financeAmount=" + financeAmount +
            ", endTime=" + endTime +
            ", status=" + status +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
