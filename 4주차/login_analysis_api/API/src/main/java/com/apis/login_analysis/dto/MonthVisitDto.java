package com.apis.login_analysis.dto;


public class MonthVisitDto{
	private final int page;
	private final String yearMonth;
	private final int counts; // 접속자 또는 로그인 수 
	private boolean isEnd;
	public MonthVisitDto(int page,Object year,Object month, Object counts,boolean isEnd) {
		this.page = page;
		this.yearMonth = String.valueOf(year) + String.valueOf(month);
		this.counts = Integer.parseInt(String.valueOf(counts));
		this.isEnd = isEnd;
	}
	
	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public int getPage() {
		return page;
	}

	public String getYearMonth() {
		return yearMonth;
	}
	public int getCounts() {
		return counts;
	}
}
