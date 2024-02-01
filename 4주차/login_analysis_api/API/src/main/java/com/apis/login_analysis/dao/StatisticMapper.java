package com.apis.login_analysis.dao;

import java.util.HashMap;
import java.util.List;

public interface StatisticMapper {
	/*
	 * APIs
	 * 1. 월별 접속자 수
	 * 2. 일자별 접속자 수 
	 * 3. 평균 하루 로그인 수
	 * 4. 휴일을 제외한 로그인 수
	 * 5. 부서별 월별 로그
	 * */
	public List<HashMap<String,Object>> MonthVisit();
	public List<HashMap<String,Object>> DayVisit();
	public List<HashMap<String,Object>> AvgDailyLogin();
	public List<HashMap<String,Object>> WeekdayLogin();
	public List<HashMap<String,Object>> DepartMonthLog();
}
