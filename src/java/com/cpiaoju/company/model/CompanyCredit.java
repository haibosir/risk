package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 企业授信; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_credit")
public class CompanyCredit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long companyId;

    /**
     * 授信文件名称
     */
    private String creditFileName;

    /**
     * 授信文件地址
     */
    private String creditFileUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 截止日期
     */
    private LocalDateTime endTime;

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
    public String getCreditFileName() {
        return creditFileName;
    }

    public void setCreditFileName(String creditFileName) {
        this.creditFileName = creditFileName;
    }
    public String getCreditFileUrl() {
        return creditFileUrl;
    }

    public void setCreditFileUrl(String creditFileUrl) {
        this.creditFileUrl = creditFileUrl;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CompanyCredit{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", creditFileName=" + creditFileName +
            ", creditFileUrl=" + creditFileUrl +
            ", createTime=" + createTime +
            ", endTime=" + endTime +
        "}";
    }
}
