package com.msds.common;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 分页基础
 * 
 * @author LiLong 2014-7-29
 * 
 */
public class BasePage {

	public static final char UNDERLINE = '_';

	@JsonIgnore
	private Integer pageIndex = 0;
	@JsonIgnore
	private Integer pageSize = 20;
	@JsonIgnore
	private String sortField;
	@JsonIgnore
	private String sortOrder;

	/**
	 * 分页导航
	 */
	@JsonIgnore
	private Pager pager = new Pager();

	public Pager getPager() {
		pager.setPageId(getPageIndex());
		pager.setPageSize(getPageSize());
		String orderField = "";
		if (StringUtils.isNotBlank(sortField)) {
			orderField = getDBField(sortField);
		}
		if (StringUtils.isNotBlank(orderField)
				&& StringUtils.isNotBlank(sortOrder)) {
			orderField += " " + sortOrder;
		}
		pager.setOrderField(orderField);
		return pager;
	}

	private static String getDBField(String pageField) {
		if (pageField == null || "".equals(pageField.trim())) {
			return "";
		}
		int len = pageField.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = pageField.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

}
