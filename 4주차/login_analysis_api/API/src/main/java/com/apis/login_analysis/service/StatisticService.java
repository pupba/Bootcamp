package com.apis.login_analysis.service;
import com.apis.login_analysis.dto.*;

public interface StatisticService {
	public BaseDto monthVisit();
	public BaseDto dayVisit(String day);
	public BaseDto avgDailyLogin();
	public BaseDto weekdayLogin();
	public BaseDto departMonthLog(String depart);
}
