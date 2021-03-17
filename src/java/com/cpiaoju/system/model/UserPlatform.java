package com.cpiaoju.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户平台关联表; InnoDB free: 9216 kB
 * </p>
 *
 * @author huhb
 * @since 2020-11-25
 */
@TableName("sys_user_platform")
public class UserPlatform implements Serializable {

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
     * 平台id
     */
    private Integer platformId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 平台名称
     */
    @TableField(exist = false)
    private String platformName;


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
    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "UserPlatform{" +
            "id=" + id +
            ", userId=" + userId +
            ", platformId=" + platformId +
            ", createTime=" + createTime +
            ", platformName=" + platformName +
        "}";
    }
}
