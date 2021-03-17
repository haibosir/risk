package com.cpiaoju.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统配置; InnoDB free: 8192 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-03
 */
@TableName("sys_config")
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品要素审核
     */
    private String productElement;

    /**
     * 平台规则审核
     */
    private String platformRules;

    /**
     * 产品规则审核
     */
    private String productRules;

    /**
     * 企业风险通知
     */
    private String enterpriseRisk;

    /**
     * 发票风险通知
     */
    private String invoiceRisk;

    /**
     * 承兑提示通知
     */
    private String acceptance;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 期限0每次1六个小时2八个小时3一天
     */
    private Integer term;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductElement() {
        return productElement;
    }

    public void setProductElement(String productElement) {
        this.productElement = productElement;
    }
    public String getPlatformRules() {
        return platformRules;
    }

    public void setPlatformRules(String platformRules) {
        this.platformRules = platformRules;
    }
    public String getProductRules() {
        return productRules;
    }

    public void setProductRules(String productRules) {
        this.productRules = productRules;
    }
    public String getEnterpriseRisk() {
        return enterpriseRisk;
    }

    public void setEnterpriseRisk(String enterpriseRisk) {
        this.enterpriseRisk = enterpriseRisk;
    }
    public String getInvoiceRisk() {
        return invoiceRisk;
    }

    public void setInvoiceRisk(String invoiceRisk) {
        this.invoiceRisk = invoiceRisk;
    }
    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
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
    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Config{" +
            "id=" + id +
            ", productElement=" + productElement +
            ", platformRules=" + platformRules +
            ", productRules=" + productRules +
            ", enterpriseRisk=" + enterpriseRisk +
            ", invoiceRisk=" + invoiceRisk +
            ", acceptance=" + acceptance +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", term=" + term +
        "}";
    }
}
