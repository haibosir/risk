package com.cpiaoju.intelligent.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 渠道; InnoDB free: 9216 kB
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
@TableName("sys_channel")
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道网址
     */
    private String channelWebsite;

    /**
     * 渠道联系人
     */
    private String contacts;

    /**
     * 渠道联系电话
     */
    private String contactsTel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 0有效1无效
     */
    private Integer status;

    /**
     *数据个数
     */
    private Integer dataCount;

    /**
     *调用频次
     */
    private Integer userdCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    public String getChannelWebsite() {
        return channelWebsite;
    }

    public void setChannelWebsite(String channelWebsite) {
        this.channelWebsite = channelWebsite;
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public Integer getUserdCount() {
        return userdCount;
    }

    public void setUserdCount(Integer userdCount) {
        this.userdCount = userdCount;
    }

    @Override
    public String toString() {
        return "Channel{" +
            "id=" + id +
            ", channelName=" + channelName +
            ", channelWebsite=" + channelWebsite +
            ", contacts=" + contacts +
            ", contactsTel=" + contactsTel +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", status=" + status +
            ", userdCount=" + userdCount +
            ", dataCount=" + dataCount +
        "}";
    }
}
