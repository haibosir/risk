package com.cpiaoju.product.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 产品; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String applyNo;

    /**
     * 产品编码
     */
    private String productNo;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 来源
     */
    private Long source;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 状态0正常1删除
     */
    private Integer status;

    private Integer approvalStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    /**
     * 调用次数
     */
    private Long userdCount;

    private String approvalUser;

    @TableField(exist = false)
    private String sourceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
    public Long getUserdCount() {
        return userdCount;
    }

    public void setUserdCount(Long userdCount) {
        this.userdCount = userdCount;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", productNo=" + productNo +
            ", productName=" + productName +
            ", source=" + source +
            ", createUser=" + createUser +
            ", status=" + status +
            ", createTime=" + createTime +
            ", userdCount=" + userdCount +
        "}";
    }
}
