package com.cpiaoju.order.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 * <p>
 * 订单协议; InnoDB free: 7168 kB
 * </p>
 *
 * @author huhb
 * @since 2020-12-30
 */
@TableName("sys_order_agreement")
public class OrderAgreement implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 协议地址
     */
    private String fileUrl;

    /**
     * 协议名称
     */
    private String fileName;

    /**
     * 订单id
     */
    private Integer oid;

    /**
     * 0协议 1其他文件
     */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OrderAgreement{" +
            "id=" + id +
            ", fileUrl=" + fileUrl +
            ", fileName=" + fileName +
            ", oid=" + oid +
        "}";
    }
}
