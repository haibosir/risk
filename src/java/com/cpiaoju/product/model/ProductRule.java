package com.cpiaoju.product.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cpiaoju.intelligent.model.PlatformRuleDetail;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 产品规则; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_product_rule")
public class ProductRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规则编号
     */
    private String ruleNo;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 产品id
     */
    private Long productId;

    private Integer approvalStatus;

    @TableField(exist = false)
    private List<ProductRuleDetail> productRuleDetailList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<ProductRuleDetail> getProductRuleDetailList() {
        return productRuleDetailList;
    }

    public void setProductRuleDetailList(List<ProductRuleDetail> productRuleDetailList) {
        this.productRuleDetailList = productRuleDetailList;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "ProductRule{" +
            "id=" + id +
            ", ruleNo=" + ruleNo +
            ", productName=" + productName +
            ", platformId=" + platformId +
            ", createTime=" + createTime +
            ", status=" + status +
            ", updateTime=" + updateTime +
            ", productId=" + productId +
        "}";
    }
}
