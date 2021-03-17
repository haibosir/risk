package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 企业信息-日志表; InnoDB free: 7168 kB; (`company_id`) REFER `risk_manager/sys_company`(
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_log")
public class CompanyLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 企业信息id
     */
    private Long companyId;

    /**
     * 违规原因
     */
    private String violationsReasons;

    /**
     * 移除原因
     */
    private String removeReasons;

    /**
     * 创建时间
     */
    private Date createTime;

    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    public String getViolationsReasons() {
        return violationsReasons;
    }

    public void setViolationsReasons(String violationsReasons) {
        this.violationsReasons = violationsReasons;
    }
    public String getRemoveReasons() {
        return removeReasons;
    }

    public void setRemoveReasons(String removeReasons) {
        this.removeReasons = removeReasons;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CompanyLog{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", violationsReasons=" + violationsReasons +
            ", removeReasons=" + removeReasons +
            ", createTime=" + createTime +
        "}";
    }
}
