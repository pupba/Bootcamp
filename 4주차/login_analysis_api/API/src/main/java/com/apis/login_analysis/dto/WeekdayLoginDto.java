package com.apis.login_analysis.dto;

public class WeekdayLoginDto {
	private final int page;
	private final String date;
	private final int wkdLoginCount;
	private boolean isEnd;
	
	public WeekdayLoginDto(int page,Object date,Object wkdLoginCount,boolean isEnd) {
		this.page = page;
		this.date = String.valueOf(date);
		this.wkdLoginCount = Integer.parseInt(String.valueOf(wkdLoginCount));
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

	public String getDate() {
		return date;
	}

	public int getWkdLoginCount() {
		return wkdLoginCount;
	}
}
