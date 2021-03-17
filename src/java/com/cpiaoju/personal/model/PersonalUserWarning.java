package com.cpiaoju.personal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 个人用户预警; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@TableName("sys_personal_user_warning")
public class PersonalUserWarning implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    /**
     * 预警编号
     */
    private String warnNo;

    /**
     * 预警位置
     */
    private String warnPosition;

    /**
     * 预警对象
     */
    private String warnTarget;

    /**
     * 预警级别
     */
    private String warnLevel;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 评分
     */
    private String score;

    /**
     * 状态
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getWarnNo() {
        return warnNo;
    }

    public void setWarnNo(String warnNo) {
        this.warnNo = warnNo;
    }
    public String getWarnPosition() {
        return warnPosition;
    }

    public void setWarnPosition(String warnPosition) {
        this.warnPosition = warnPosition;
    }
    public String getWarnTarget() {
        return warnTarget;
    }

    public void setWarnTarget(String warnTarget) {
        this.warnTarget = warnTarget;
    }
    public String getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PersonalUserWarning{" +
            "id=" + id +
            ", userId=" + userId +
            ", warnNo=" + warnNo +
            ", warnPosition=" + warnPosition +
            ", warnTarget=" + warnTarget +
            ", warnLevel=" + warnLevel +
            ", createTime=" + createTime +
            ", score=" + score +
            ", status=" + status +
        "}";
    }
}
