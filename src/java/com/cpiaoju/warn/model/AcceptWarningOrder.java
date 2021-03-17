package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 风险预警-承兑提示-票据信息; InnoDB free: 8192 kB
 * </p>
 *
 * @author huhb
 * @since 2021-01-05
 */
@TableName("sys_accept_warning_order")
public class AcceptWarningOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 汇票编号
     */
    private String draftNo;

    /**
     * 票面金额
     */
    private String financeAmount;

    /**
     * 出票日期
     */
    private LocalDate startTime;

    /**
     * 到期日
     */
    private LocalDate endTime;

    /**
     * 出票人名称
     */
    private String sellName;

    /**
     * 出票人账号
     */
    private String sellAccount;

    /**
     * 出票人开户行
     */
    private String sellBank;

    /**
     * 出票保证人
     */
    private String sellGuarantor;

    /**
     * 保证日期
     */
    private LocalDateTime sellGuarantorDate;

    /**
     * 保证人地址
     */
    private String sellGuarantorAddress;

    /**
     * 收款人名称
     */
    private String buyName;

    /**
     * 收款人账号
     */
    private String buyAccount;

    /**
     * 收款人开户行
     */
    private String buyBank;

    /**
     * 承兑人名称
     */
    private String acceptor;

    /**
     * 承兑人账号
     */
    private String acceptorAccount;

    /**
     * 承兑人开户行
     */
    private String acceptorBank;

    /**
     * 承兑人开户行号
     */
    private String acceptorBankNo;

    /**
     * 承兑保证人名称
     */
    private String acceptorGuarantor;

    /**
     * 承兑保证日期
     */
    private LocalDateTime acceptorGuarantorDate;

    /**
     * 0可以转让1不可转让
     */
    private Integer isTransfer;

    /**
     * 转手次数
     */
    private Integer transferCount;

    /**
     * 票据正面url
     */
    private String draftFontImg;

    /**
     * 票据反面url
     */
    private String draftBackImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getDraftNo() {
        return draftNo;
    }

    public void setDraftNo(String draftNo) {
        this.draftNo = draftNo;
    }
    public String getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(String financeAmount) {
        this.financeAmount = financeAmount;
    }
    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }
    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }
    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }
    public String getSellAccount() {
        return sellAccount;
    }

    public void setSellAccount(String sellAccount) {
        this.sellAccount = sellAccount;
    }
    public String getSellBank() {
        return sellBank;
    }

    public void setSellBank(String sellBank) {
        this.sellBank = sellBank;
    }
    public String getSellGuarantor() {
        return sellGuarantor;
    }

    public void setSellGuarantor(String sellGuarantor) {
        this.sellGuarantor = sellGuarantor;
    }
    public LocalDateTime getSellGuarantorDate() {
        return sellGuarantorDate;
    }

    public void setSellGuarantorDate(LocalDateTime sellGuarantorDate) {
        this.sellGuarantorDate = sellGuarantorDate;
    }
    public String getSellGuarantorAddress() {
        return sellGuarantorAddress;
    }

    public void setSellGuarantorAddress(String sellGuarantorAddress) {
        this.sellGuarantorAddress = sellGuarantorAddress;
    }
    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }
    public String getBuyAccount() {
        return buyAccount;
    }

    public void setBuyAccount(String buyAccount) {
        this.buyAccount = buyAccount;
    }
    public String getBuyBank() {
        return buyBank;
    }

    public void setBuyBank(String buyBank) {
        this.buyBank = buyBank;
    }
    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }
    public String getAcceptorAccount() {
        return acceptorAccount;
    }

    public void setAcceptorAccount(String acceptorAccount) {
        this.acceptorAccount = acceptorAccount;
    }
    public String getAcceptorBank() {
        return acceptorBank;
    }

    public void setAcceptorBank(String acceptorBank) {
        this.acceptorBank = acceptorBank;
    }
    public String getAcceptorBankNo() {
        return acceptorBankNo;
    }

    public void setAcceptorBankNo(String acceptorBankNo) {
        this.acceptorBankNo = acceptorBankNo;
    }
    public String getAcceptorGuarantor() {
        return acceptorGuarantor;
    }

    public void setAcceptorGuarantor(String acceptorGuarantor) {
        this.acceptorGuarantor = acceptorGuarantor;
    }
    public LocalDateTime getAcceptorGuarantorDate() {
        return acceptorGuarantorDate;
    }

    public void setAcceptorGuarantorDate(LocalDateTime acceptorGuarantorDate) {
        this.acceptorGuarantorDate = acceptorGuarantorDate;
    }
    public Integer getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(Integer isTransfer) {
        this.isTransfer = isTransfer;
    }
    public Integer getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(Integer transferCount) {
        this.transferCount = transferCount;
    }
    public String getDraftFontImg() {
        return draftFontImg;
    }

    public void setDraftFontImg(String draftFontImg) {
        this.draftFontImg = draftFontImg;
    }
    public String getDraftBackImg() {
        return draftBackImg;
    }

    public void setDraftBackImg(String draftBackImg) {
        this.draftBackImg = draftBackImg;
    }

    @Override
    public String toString() {
        return "AcceptWarningOrder{" +
            "id=" + id +
            ", draftNo=" + draftNo +
            ", financeAmount=" + financeAmount +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", sellName=" + sellName +
            ", sellAccount=" + sellAccount +
            ", sellBank=" + sellBank +
            ", sellGuarantor=" + sellGuarantor +
            ", sellGuarantorDate=" + sellGuarantorDate +
            ", sellGuarantorAddress=" + sellGuarantorAddress +
            ", buyName=" + buyName +
            ", buyAccount=" + buyAccount +
            ", buyBank=" + buyBank +
            ", acceptor=" + acceptor +
            ", acceptorAccount=" + acceptorAccount +
            ", acceptorBank=" + acceptorBank +
            ", acceptorBankNo=" + acceptorBankNo +
            ", acceptorGuarantor=" + acceptorGuarantor +
            ", acceptorGuarantorDate=" + acceptorGuarantorDate +
            ", isTransfer=" + isTransfer +
            ", transferCount=" + transferCount +
            ", draftFontImg=" + draftFontImg +
            ", draftBackImg=" + draftBackImg +
        "}";
    }
}
