package com.cpiaoju.product.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 审核日志; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_product_approval_log")
public class ProductApprovalLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    /**
     * 审核状态
     */
    private Integer status;

    /**
     * 审核内容描述
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 审核岗位
     */
    private String approvalPost;

    private String approvalUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getApprovalPost() {
        return approvalPost;
    }

    public void setApprovalPost(String approvalPost) {
        this.approvalPost = approvalPost;
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser;
    }

    @Override
    public String toString() {
        return "ProductApprovalLog{" +
            "id=" + id +
            ", productId=" + productId +
            ", status=" + status +
            ", remark=" + remark +
            ", createTime=" + createTime +
            ", approvalPost=" + approvalPost +
        "}";
    }
}
