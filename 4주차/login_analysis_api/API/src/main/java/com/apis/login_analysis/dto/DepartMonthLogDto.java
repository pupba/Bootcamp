package com.apis.login_analysis.dto;

public class DepartMonthLogDto {
	private final int page;
	private final String depart;
	private final String date;
	private final int department_monthly_login;
	private boolean isEnd;
	
	public DepartMonthLogDto(int page,Object depart,Object year,Object month,Object department_monthly_login,boolean isEnd) {
		this.page = page;
		this.depart = String.valueOf(depart);
		this.date = String.valueOf(year)+String.valueOf(month);
		this.department_monthly_login = Integer.parseInt(String.valueOf(department_monthly_login));
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

	public String getDepart() {
		return depart;
	}

	public String getDate() {
		return date;
	}

	public int getDepartment_monthly_login() {
		return department_monthly_login;
	}
}
