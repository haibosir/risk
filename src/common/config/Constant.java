package com.cpiaoju.common.config;

public interface Constant {


    /**
     * 短信模板状态启动
     */
    Integer MESSAGE_TEMPLATE_USER = 0;
    /**
     * 短信模板状态删除
     */
    Integer MESSAGE_TEMPLATE_UNUSER = 1;
    /**
     * 状态 0有效 1无效
     */
    Integer SYSTEM_STATUS_VALID = 0;

    /**
     * 状态 0有效 1无效
     */
    Integer SYSTEM_STATUS_UNVALID = 1;
    /**
     *删除标记
     */
    String DELETE_FLAG = "1";

    /**
     *未标记
     */
    String UN_DELETE_FLAG = "0";

}
