package com.cpiaoju.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String comments;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public Role() {
    }

    public Role(Integer roleId, String roleName, String comments) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.comments = comments;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    @Override
    public String toString() {
        return "Role{" +
                ", roleId=" + roleId +
                ", roleName=" + roleName +
                ", comments=" + comments +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
