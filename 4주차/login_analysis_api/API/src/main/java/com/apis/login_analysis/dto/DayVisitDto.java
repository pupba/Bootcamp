package com.apis.login_analysis.dto;

public class DayVisitDto {
	
	private final int page;
	private final String day;
	private final int usrCount;
	private boolean isEnd;
	
	public DayVisitDto(int page,Object day,Object usrCount,boolean isEnd) {
		this.page = page;
		this.day = String.valueOf(day);
		this.usrCount = Integer.parseInt(String.valueOf(usrCount));
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

	public String getDay() {
		return day;
	}

	public int getUsrCount() {
		return usrCount;
	}
}
