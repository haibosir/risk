package com.cpiaoju.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 无票保理-贸易合同表; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_order_contract")
public class OrderContract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *  订单id
     */
    private Integer oid;

    /**
     * 合同名称
     */
    private String name;

    /**
     * 债务人名称
     */
    private String debtorName;

    /**
     * 贸易金额
     */
    private String amount;

    /**
     * 合同有效开始日期
     */
    private String startTime;

    /**
     * 合同有效结束日期
     */
    private String endTime;

    /**
     * 合同签署日期
     */
    private String signTime;

    /**
     * 合同pdf文件地址
     */
    private String contractPdf;

    /**
     * 合同封面文件地址
     */
    private String contractCover;

    /**
     * 合同首页文件地址
     */
    private String contractHome;

    /**
     * 合同价格页文件地址
     */
    private String contractPrice;

    /**
     * 合同支付方式页
     */
    private String contractPayment;

    /**
     * 合同盖章页面
     */
    private String contractSeal;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private List<OrderContractFile> contractFiles;

    private List<OrderContractInvoice> invoices;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }
    public String getContractPdf() {
        return contractPdf;
    }

    public void setContractPdf(String contractPdf) {
        this.contractPdf = contractPdf;
    }
    public String getContractCover() {
        return contractCover;
    }

    public void setContractCover(String contractCover) {
        this.contractCover = contractCover;
    }
    public String getContractHome() {
        return contractHome;
    }

    public void setContractHome(String contractHome) {
        this.contractHome = contractHome;
    }
    public String getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(String contractPrice) {
        this.contractPrice = contractPrice;
    }
    public String getContractPayment() {
        return contractPayment;
    }

    public void setContractPayment(String contractPayment) {
        this.contractPayment = contractPayment;
    }
    public String getContractSeal() {
        return contractSeal;
    }

    public void setContractSeal(String contractSeal) {
        this.contractSeal = contractSeal;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public List<OrderContractFile> getContractFiles() {
        return contractFiles;
    }

    public void setContractFiles(List<OrderContractFile> contractFiles) {
        this.contractFiles = contractFiles;
    }

    public List<OrderContractInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<OrderContractInvoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "OrderContract{" +
            "id=" + id +
            ", oid=" + oid +
            ", name=" + name +
            ", debtorName=" + debtorName +
            ", amount=" + amount +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", signTime=" + signTime +
            ", contractPdf=" + contractPdf +
            ", contractCover=" + contractCover +
            ", contractHome=" + contractHome +
            ", contractPrice=" + contractPrice +
            ", contractPayment=" + contractPayment +
            ", contractSeal=" + contractSeal +
            ", createTime=" + createTime +
        "}";
    }
}
