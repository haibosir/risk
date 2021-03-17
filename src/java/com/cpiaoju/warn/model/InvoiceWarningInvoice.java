package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 发票预警合同信息; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
@TableName("sys_invoice_warning_invoice")
public class InvoiceWarningInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 贸易合同表id
     */
    private Integer cid;

    /**
     * 发票号码
     */
    private String invoiceNumber;

    /**
     * 发票代码
     */
    private String invoiceCode;

    /**
     * 发票校验码
     */
    private String code;

    /**
     * 发票开票日期
     */
    private LocalDateTime invoiceDate;

    /**
     * 发票金额
     */
    private String invoiceAmount;

    /**
     * 发票文件地址
     */
    private String invoiceUrl;

    /**
     * 0识别成功1识别失败
     */
    private Integer status;

    private LocalDateTime createTime;

    /**
     * 购买方
     */
    private String buyName;

    /**
     * 销售方
     */
    private String sellName;

    /**
     * 0正常1预警
     */
    private Integer isWarn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
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
    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }
    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }
    public Integer getIsWarn() {
        return isWarn;
    }

    public void setIsWarn(Integer isWarn) {
        this.isWarn = isWarn;
    }

    @Override
    public String toString() {
        return "InvoiceWarningInvoice{" +
            "id=" + id +
            ", cid=" + cid +
            ", invoiceNumber=" + invoiceNumber +
            ", invoiceCode=" + invoiceCode +
            ", code=" + code +
            ", invoiceDate=" + invoiceDate +
            ", invoiceAmount=" + invoiceAmount +
            ", invoiceUrl=" + invoiceUrl +
            ", status=" + status +
            ", createTime=" + createTime +
            ", buyName=" + buyName +
            ", sellName=" + sellName +
            ", isWarn=" + isWarn +
        "}";
    }
}
