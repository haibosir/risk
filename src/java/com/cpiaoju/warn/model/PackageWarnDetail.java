package com.cpiaoju.warn.model;


import java.io.Serializable;
import java.util.List;


public class PackageWarnDetail implements Serializable {

  private static final long serialVersionUID = 1L;

  private  List<CompanyWarnDetail> detailList;

    public List<CompanyWarnDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<CompanyWarnDetail> detailList) {
        this.detailList = detailList;
    }
}
