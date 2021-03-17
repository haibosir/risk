package com.cpiaoju.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 短信记录; InnoDB free: 9216 kB
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
@TableName("sys_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer templateId;

    /**
     * 接收人
     */
    private String receiver;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 0发送成功1发送失败
     */
    private Integer status;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    @TableField(exist = false)
    private String templateName;//短信模板名称


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public String toString() {
        return "Message{" +
            "id=" + id +
            ", templateId=" + templateId +
            ", receiver=" + receiver +
            ", phone=" + phone +
            ", status=" + status +
            ", content=" + content +
            ", createTime=" + createTime +
        "}";
    }
}
