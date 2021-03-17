package com.cpiaoju.warn.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 反馈记录; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
@TableName("sys_feedback")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联id
     */
    private Long relationId;

    /**
     * 反馈内容
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 状态0未处理1已处理
     */
    private Integer status;

    /**
     * 反馈人
     */
    private String tickling;

    private List<FeedbackAnnex> annexList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getTickling() {
        return tickling;
    }

    public void setTickling(String tickling) {
        this.tickling = tickling;
    }

    public List<FeedbackAnnex> getAnnexList() {
        return annexList;
    }

    public void setAnnexList(List<FeedbackAnnex> annexList) {
        this.annexList = annexList;
    }

    @Override
    public String toString() {
        return "Feedback{" +
            "id=" + id +
            ", relationId=" + relationId +
            ", remark=" + remark +
            ", createTime=" + createTime +
            ", status=" + status +
            ", tickling=" + tickling +
        "}";
    }
}
