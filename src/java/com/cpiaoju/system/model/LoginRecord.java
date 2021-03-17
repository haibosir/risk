package com.cpiaoju.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 登录日志
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
@TableName("sys_login_record")
public class LoginRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 设备名
     */
    private String device;

    /**
     * 浏览器类型
     */
    private String browserType;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 登录时间
     */
    private LocalDateTime createTime;
    /**
     * 操作描述
     */
    private String remark;

    @TableField(exist = false)
    private String username;  // 用户名称

    @TableField(exist = false)
    private String account;  // 用户账号


    @TableField(exist = false)
    private String roleName;  // 角色名称


    @TableField(exist = false)
    private String platformNames;  //平台名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPlatformNames() {
        return platformNames;
    }

    public void setPlatformNames(String platformNames) {
        this.platformNames = platformNames;
    }

    @Override
    public String toString() {
        return "LoginRecord{" +
                ", id=" + id +
                ", userId=" + userId +
                ", osName=" + osName +
                ", device=" + device +
                ", browserType=" + browserType +
                ", ipAddress=" + ipAddress +
                ", createTime=" + createTime +
                ", remark=" + remark +
                "}";
    }
}
