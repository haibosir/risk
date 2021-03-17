package com.cpiaoju.company.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 企业经办人; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_company_agent")
public class CompanyAgent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 经办人名称
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 角色
     */
    private String roleName;

    /**
     * 职务
     */
    private String post;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

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
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "CompanyAgent{" +
            "id=" + id +
            ", userName=" + userName +
            ", phone=" + phone +
            ", roleName=" + roleName +
            ", post=" + post +
            ", createTime=" + createTime +
            ", companyId=" + companyId +
        "}";
    }
}
