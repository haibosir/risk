package com.cpiaoju.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 短信模板; InnoDB free: 9216 kB
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
@TableName("sys_message_template")
public class MessageTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "template_id", type = IdType.AUTO)
    private Integer templateId;

    /**
     * 字段场景id
     */
    private Integer dictId;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 编辑事件
     */
    private LocalDateTime updateTime;

    /**
     * 0未删除1已删除
     */
    private Integer status;

    /**
     * 0通过测试1未通过测试
     */
    private Integer isTest;

    /**
     *模板编号
     */
    private String templateNo;

    /**
     * 模板名称
     */
    @TableField(exist = false)
    private String templateName;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getIsTest() {
        return isTest;
    }

    public void setIsTest(Integer isTest) {
        this.isTest = isTest;
    }

    public String getTemplateNo() {
        return templateNo;
    }

    public void setTemplateNo(String templateNo) {
        this.templateNo = templateNo;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public String toString() {
        return "MessageTemplate{" +
            "templateId=" + templateId +
            ", dictId=" + dictId +
            ", content=" + content +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", status=" + status +
            ", isTest=" + isTest +
            ", templateNo=" + templateNo +
        "}";
    }
}
