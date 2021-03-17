package com.cpiaoju.intelligent.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 平台数据; InnoDB free: 8192 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-02
 */
@TableName("sys_platform")
public class Platform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台编号
     */
    private String platformNo;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 平台网址
     */
    private String platformWebsite;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系人电话
     */
    private String contactsTel;

    /**
     * 0正常1删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 调用频次
     */
    private Integer userdCount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getPlatformNo() {
        return platformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }
    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
    public String getPlatformWebsite() {
        return platformWebsite;
    }

    public void setPlatformWebsite(String platformWebsite) {
        this.platformWebsite = platformWebsite;
    }
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
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
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserdCount() {
        return userdCount;
    }

    public void setUserdCount(Integer userdCount) {
        this.userdCount = userdCount;
    }

    @Override
    public String toString() {
        return "Platform{" +
            "id=" + id +
            ", platformNo=" + platformNo +
            ", platformName=" + platformName +
            ", platformWebsite=" + platformWebsite +
            ", contacts=" + contacts +
            ", contactsTel=" + contactsTel +
            ", status=" + status +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", userdCount=" + userdCount +
        "}";
    }
}
