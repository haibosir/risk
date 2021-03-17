package com.cpiaoju.order.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 订单表; InnoDB free: 8192 kB
 * 
 * @author hhb
 * @email 925657651@qq.com
 * @date 2021-01-15 11:00:50
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//汇票编号
	private String draftNo;
	//订单编号
	private String orderNo;
	//产品编号
	private Integer productId;
	//融资企业名称
	private String companyName;
	//订单状态 0 保存中 1 待保理公司审核  2 等待财务初审 3财务复审 4 贴现完成 5 贴现失败 6 贴现时用户主动取消不可编辑
	private Integer status;
	//申请时间
	private Date createTime;
	//融资金额
	private String financeAmount;
	//融资利率
	private String financingInter;
	//放款金额
	private String payAmount;
	//承兑人名称
	private String acceptor;
	//收票人名称
	private String buyName;
	//出票日期
	private Date startTime;
	//到期日
	private Date endTime;
	//0可以转让1不可
	private Integer isTransfer;
	//转让次数
	private Integer transferCount;
	//融资费用
	private String financingCost;
	//服务费用
	private String servicefee;
	//背书账户 银行表id
	private Integer bankId;
	//贴现账户银行 id
	private Integer discountId;
	//修改时间
	private Date updateTime;
	//票据正面
	private String draftImg;
	//票据反面
	private String draftBackImg;
	//付款凭证地址
	private String paymentVoucher;

	private List<OrderContract> contracts;

	private String productName;

	private String platformName;

	private String companyTypeName;

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
	 * 设置：汇票编号
	 */
	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}
	/**
	 * 获取：汇票编号
	 */
	public String getDraftNo() {
		return draftNo;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：产品编号
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：产品编号
	 */
	public Integer getProductId() {
		return productId;
	}
	/**
	 * 设置：融资企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：融资企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：订单状态 0 保存中 1 待保理公司审核  2 等待财务初审 3财务复审 4 贴现完成 5 贴现失败 6 贴现时用户主动取消不可编辑
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态 0 保存中 1 待保理公司审核  2 等待财务初审 3财务复审 4 贴现完成 5 贴现失败 6 贴现时用户主动取消不可编辑
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：申请时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：融资金额
	 */
	public void setFinanceAmount(String financeAmount) {
		this.financeAmount = financeAmount;
	}
	/**
	 * 获取：融资金额
	 */
	public String getFinanceAmount() {
		return financeAmount;
	}
	/**
	 * 设置：融资利率
	 */
	public void setFinancingInter(String financingInter) {
		this.financingInter = financingInter;
	}
	/**
	 * 获取：融资利率
	 */
	public String getFinancingInter() {
		return financingInter;
	}
	/**
	 * 设置：放款金额
	 */
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	/**
	 * 获取：放款金额
	 */
	public String getPayAmount() {
		return payAmount;
	}
	/**
	 * 设置：承兑人名称
	 */
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	/**
	 * 获取：承兑人名称
	 */
	public String getAcceptor() {
		return acceptor;
	}
	/**
	 * 设置：收票人名称
	 */
	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}
	/**
	 * 获取：收票人名称
	 */
	public String getBuyName() {
		return buyName;
	}
	/**
	 * 设置：出票日期
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：出票日期
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：到期日
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：到期日
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：0可以转让1不可
	 */
	public void setIsTransfer(Integer isTransfer) {
		this.isTransfer = isTransfer;
	}
	/**
	 * 获取：0可以转让1不可
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
	 * 设置：融资费用
	 */
	public void setFinancingCost(String financingCost) {
		this.financingCost = financingCost;
	}
	/**
	 * 获取：融资费用
	 */
	public String getFinancingCost() {
		return financingCost;
	}
	/**
	 * 设置：服务费用
	 */
	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}
	/**
	 * 获取：服务费用
	 */
	public String getServicefee() {
		return servicefee;
	}
	/**
	 * 设置：背书账户 银行表id
	 */
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	/**
	 * 获取：背书账户 银行表id
	 */
	public Integer getBankId() {
		return bankId;
	}
	/**
	 * 设置：贴现账户银行 id
	 */
	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}
	/**
	 * 获取：贴现账户银行 id
	 */
	public Integer getDiscountId() {
		return discountId;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：票据正面
	 */
	public void setDraftImg(String draftImg) {
		this.draftImg = draftImg;
	}
	/**
	 * 获取：票据正面
	 */
	public String getDraftImg() {
		return draftImg;
	}
	/**
	 * 设置：票据反面
	 */
	public void setDraftBackImg(String draftBackImg) {
		this.draftBackImg = draftBackImg;
	}
	/**
	 * 获取：票据反面
	 */
	public String getDraftBackImg() {
		return draftBackImg;
	}
	/**
	 * 设置：付款凭证地址
	 */
	public void setPaymentVoucher(String paymentVoucher) {
		this.paymentVoucher = paymentVoucher;
	}
	/**
	 * 获取：付款凭证地址
	 */
	public String getPaymentVoucher() {
		return paymentVoucher;
	}


	public List<OrderContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<OrderContract> contracts) {
		this.contracts = contracts;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getCompanyTypeName() {
		return companyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
	}
}
