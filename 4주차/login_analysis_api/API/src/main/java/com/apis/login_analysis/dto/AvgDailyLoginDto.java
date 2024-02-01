package com.apis.login_analysis.dto;


public class AvgDailyLoginDto {
	private final int page;
	private final String year;
	private final int avgLoginCount;
	private boolean isEnd;
	
	public AvgDailyLoginDto(int page,Object year,Object avgLoginCount,boolean isEnd) {
		this.page = page;
		this.year = String.valueOf(year);
		this.avgLoginCount = Integer.parseInt(String.valueOf(avgLoginCount));
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

	public String getYear() {
		return year;
	}

	public int getAvgLoginCount() {
		return avgLoginCount;
	}
}
