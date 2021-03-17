package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 变更记录; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_change_log")
public class CompanyChangeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 变更日期
     */
    private Date createTime;

    /**
     * 变更项目
     */
    private String changeProject;

    /**
     * 变更前
     */
    private String beforeChange;

    /**
     * 变更后
     */
    private String afterChange;

    /**
     * 企业id
     */
    private Long companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getChangeProject() {
        return changeProject;
    }

    public void setChangeProject(String changeProject) {
        this.changeProject = changeProject;
    }
    public String getBeforeChange() {
        return beforeChange;
    }

    public void setBeforeChange(String beforeChange) {
        this.beforeChange = beforeChange;
    }
    public String getAfterChange() {
        return afterChange;
    }

    public void setAfterChange(String afterChange) {
        this.afterChange = afterChange;
    }
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "CompanyChangeLog{" +
            "id=" + id +
            ", createTime=" + createTime +
            ", changeProject=" + changeProject +
            ", beforeChange=" + beforeChange +
            ", afterChange=" + afterChange +
            ", companyId=" + companyId +
        "}";
    }
}
