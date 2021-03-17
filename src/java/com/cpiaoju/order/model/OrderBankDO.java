package com.cpiaoju.order.model;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单--银行信息; InnoDB free: 8192 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-01-15 11:00:50
 */
public class OrderBankDO implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	private Integer id;
	//企业名称
	private String companyName;
	//开户银行
	private String bankName;
	//银行账号
	private String bankNo;
	//清算联行号
	private String clearingBankNo;

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
	 * 设置：企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：开户银行
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * 获取：开户银行
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 设置：银行账号
	 */
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	/**
	 * 获取：银行账号
	 */
	public String getBankNo() {
		return bankNo;
	}
	/**
	 * 设置：清算联行号
	 */
	public void setClearingBankNo(String clearingBankNo) {
		this.clearingBankNo = clearingBankNo;
	}
	/**
	 * 获取：清算联行号
	 */
	public String getClearingBankNo() {
		return clearingBankNo;
	}
}
