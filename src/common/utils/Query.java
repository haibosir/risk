package com.cpiaoju.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	// 
	private int page;
	// 每页条数
	private int limit;

	public Query(Map<String, Object> params) {
		this.putAll(params);
		// 分页参数
		if(!CommonUtil.isEmpty(params.get("page"))){
			this.page = Integer.parseInt(params.get("page").toString());
			this.limit = Integer.parseInt(params.get("limit").toString());
			this.put("offset", (page-1)*limit);
			this.put("limit", limit);
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.put("page", page);
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
