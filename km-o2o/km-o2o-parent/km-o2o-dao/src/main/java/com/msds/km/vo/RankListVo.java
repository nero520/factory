package com.msds.km.vo;

import java.util.List;

import org.apache.poi.ss.formula.functions.Rank;


public class RankListVo extends BaseVo{

	private static final long serialVersionUID = -4874232805523244020L;
	
	List<RankVo> dayList ;
	
	List<RankVo> monthList ;

	public List<RankVo> getDayList() {
		return dayList;
	}

	public void setDayList(List<RankVo> dayList) {
		this.dayList = dayList;
	}

	public List<RankVo> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<RankVo> monthList) {
		this.monthList = monthList;
	}

	
	
	
	
	
	
}
