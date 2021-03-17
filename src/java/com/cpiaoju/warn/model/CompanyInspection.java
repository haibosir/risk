package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 企业巡查; InnoDB free: 8192 kB
 * </p>
 *
 * @author huhb
 * @since 2021-01-18
 */
@TableName("sys_company_inspection")
public class CompanyInspection implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 企业id
     */
    private Integer companyId;

    /**
     * 关注间隔 字典id
     */
    private Integer dictSpaceId;

    /**
     * 更新次数
     */
    private Integer updateCount;

    /**
     * 风险等级
     */
    private Integer level;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 添加时间
     */
    private Date createTime;

    @TableField(exist = false)
    private String companyName;

    @TableField(exist = false)
    private String spaceName;

    @TableField(exist = false)
    private String levelName;

    @TableField(exist = false)
    private String companyTypeName;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
    public Integer getDictSpaceId() {
        return dictSpaceId;
    }

    public void setDictSpaceId(Integer dictSpaceId) {
        this.dictSpaceId = dictSpaceId;
    }
    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    @Override
    public String toString() {
        return "CompanyInspection{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", dictSpaceId=" + dictSpaceId +
            ", updateCount=" + updateCount +
            ", level=" + level +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
