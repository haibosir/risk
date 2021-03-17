package com.cpiaoju.order.model;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单详情; InnoDB free: 8192 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-01-15 14:08:48
 */
public class OrderDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//票据号码
	private String draftNo;
	//票据金额
	private String financeAmount;
	//开始时间
	private Date startDate;
	//到期日
	private Date endDate;
	//出票人名称
	private String sellName;
	//出票人银行账号
	private String sellAccount;
	//出票人开户行
	private String sellBankName;
	//出票保证人
	private String sellGuarantorName;
	//保证日期
	private Date guarantorDate;
	//出票保证人地址
	private String sellGuarantorAddress;
	//收票人名称
	private String drawerName;
	//收票人账号
	private String drawerAccount;
	//收票人开户行
	private String drawerBankName;
	//承兑人名称
	private String acceptorName;
	//承兑人账号
	private String acceptorAccount;
	//承兑人开户行
	private String acceptorBankName;
	//承兑人开户行号
	private String acceptorBankNo;
	//承兑保证人名称
	private String acceptorGuarantorName;
	//承兑保证日期
	private Date acceptorGuarantorDate;
	//承兑保证人地址
	private String acceptorGuarantorAddress;
	//0可以转让1不可以
	private Integer isTransfer;
	//转让次数
	private Integer transferCount;
	//订单id
	private Integer orderId;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：票据号码
	 */
	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}
	/**
	 * 获取：票据号码
	 */
	public String getDraftNo() {
		return draftNo;
	}
	/**
	 * 设置：票据金额
	 */
	public void setFinanceAmount(String financeAmount) {
		this.financeAmount = financeAmount;
	}
	/**
	 * 获取：票据金额
	 */
	public String getFinanceAmount() {
		return financeAmount;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置：到期日
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：到期日
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 设置：出票人名称
	 */
	public void setSellName(String sellName) {
		this.sellName = sellName;
	}
	/**
	 * 获取：出票人名称
	 */
	public String getSellName() {
		return sellName;
	}
	/**
	 * 设置：出票人银行账号
	 */
	public void setSellAccount(String sellAccount) {
		this.sellAccount = sellAccount;
	}
	/**
	 * 获取：出票人银行账号
	 */
	public String getSellAccount() {
		return sellAccount;
	}
	/**
	 * 设置：出票人开户行
	 */
	public void setSellBankName(String sellBankName) {
		this.sellBankName = sellBankName;
	}
	/**
	 * 获取：出票人开户行
	 */
	public String getSellBankName() {
		return sellBankName;
	}
	/**
	 * 设置：出票保证人
	 */
	public void setSellGuarantorName(String sellGuarantorName) {
		this.sellGuarantorName = sellGuarantorName;
	}
	/**
	 * 获取：出票保证人
	 */
	public String getSellGuarantorName() {
		return sellGuarantorName;
	}
	/**
	 * 设置：保证日期
	 */
	public void setGuarantorDate(Date guarantorDate) {
		this.guarantorDate = guarantorDate;
	}
	/**
	 * 获取：保证日期
	 */
	public Date getGuarantorDate() {
		return guarantorDate;
	}
	/**
	 * 设置：出票保证人地址
	 */
	public void setSellGuarantorAddress(String sellGuarantorAddress) {
		this.sellGuarantorAddress = sellGuarantorAddress;
	}
	/**
	 * 获取：出票保证人地址
	 */
	public String getSellGuarantorAddress() {
		return sellGuarantorAddress;
	}
	/**
	 * 设置：收票人名称
	 */
	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}
	/**
	 * 获取：收票人名称
	 */
	public String getDrawerName() {
		return drawerName;
	}
	/**
	 * 设置：收票人账号
	 */
	public void setDrawerAccount(String drawerAccount) {
		this.drawerAccount = drawerAccount;
	}
	/**
	 * 获取：收票人账号
	 */
	public String getDrawerAccount() {
		return drawerAccount;
	}
	/**
	 * 设置：收票人开户行
	 */
	public void setDrawerBankName(String drawerBankName) {
		this.drawerBankName = drawerBankName;
	}
	/**
	 * 获取：收票人开户行
	 */
	public String getDrawerBankName() {
		return drawerBankName;
	}
	/**
	 * 设置：承兑人名称
	 */
	public void setAcceptorName(String acceptorName) {
		this.acceptorName = acceptorName;
	}
	/**
	 * 获取：承兑人名称
	 */
	public String getAcceptorName() {
		return acceptorName;
	}
	/**
	 * 设置：承兑人账号
	 */
	public void setAcceptorAccount(String acceptorAccount) {
		this.acceptorAccount = acceptorAccount;
	}
	/**
	 * 获取：承兑人账号
	 */
	public String getAcceptorAccount() {
		return acceptorAccount;
	}
	/**
	 * 设置：承兑人开户行
	 */
	public void setAcceptorBankName(String acceptorBankName) {
		this.acceptorBankName = acceptorBankName;
	}
	/**
	 * 获取：承兑人开户行
	 */
	public String getAcceptorBankName() {
		return acceptorBankName;
	}
	/**
	 * 设置：承兑人开户行号
	 */
	public void setAcceptorBankNo(String acceptorBankNo) {
		this.acceptorBankNo = acceptorBankNo;
	}
	/**
	 * 获取：承兑人开户行号
	 */
	public String getAcceptorBankNo() {
		return acceptorBankNo;
	}
	/**
	 * 设置：承兑保证人名称
	 */
	public void setAcceptorGuarantorName(String acceptorGuarantorName) {
		this.acceptorGuarantorName = acceptorGuarantorName;
	}
	/**
	 * 获取：承兑保证人名称
	 */
	public String getAcceptorGuarantorName() {
		return acceptorGuarantorName;
	}
	/**
	 * 设置：承兑保证日期
	 */
	public void setAcceptorGuarantorDate(Date acceptorGuarantorDate) {
		this.acceptorGuarantorDate = acceptorGuarantorDate;
	}
	/**
	 * 获取：承兑保证日期
	 */
	public Date getAcceptorGuarantorDate() {
		return acceptorGuarantorDate;
	}
	/**
	 * 设置：承兑保证人地址
	 */
	public void setAcceptorGuarantorAddress(String acceptorGuarantorAddress) {
		this.acceptorGuarantorAddress = acceptorGuarantorAddress;
	}
	/**
	 * 获取：承兑保证人地址
	 */
	public String getAcceptorGuarantorAddress() {
		return acceptorGuarantorAddress;
	}
	/**
	 * 设置：0可以转让1不可以
	 */
	public void setIsTransfer(Integer isTransfer) {
		this.isTransfer = isTransfer;
	}
	/**
	 * 获取：0可以转让1不可以
	 */
	public Integer getIsTransfer() {
		return isTransfer;
	}
	/**
	 * 设置：转让次数
	 */
	public void setTransferCount(Integer transferCount) {
		this.transferCount = transferCount;
	}
	/**
	 * 获取：转让次数
	 */
	public Integer getTransferCount() {
		return transferCount;
	}
	/**
	 * 设置：订单id
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Integer getOrderId() {
		return orderId;
	}
}
