package com.apis.login_analysis.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apis.login_analysis.dto.BaseDto;
import com.apis.login_analysis.service.StatisticService;


@Controller
public class apisTest {
	@Autowired
	private StatisticService service;
	
	@ResponseBody
	@RequestMapping("/month-visit")
	public BaseDto month_visit() throws Exception{
        // 임의로 GET을 통해 url에 parameter를 입력하여 결과를 요청
        return service.monthVisit();
    }
	@ResponseBody
	@RequestMapping("/day-visit")
	public BaseDto day_visit(String day) throws Exception{
        // 임의로 GET을 통해 url에 parameter를 입력하여 결과를 요청
		if(day==null) day=" ";
        return service.dayVisit(day);
    }
	@ResponseBody
	@RequestMapping("/day-avg-login")
	public BaseDto avg_daily_login() throws Exception{
        // 임의로 GET을 통해 url에 parameter를 입력하여 결과를 요청
        return service.avgDailyLogin();
    }
	@ResponseBody
	@RequestMapping("/weekday-login")
	public BaseDto weekday_login() throws Exception{
        // 임의로 GET을 통해 url에 parameter를 입력하여 결과를 요청
        return service.weekdayLogin();
    }
	@ResponseBody
	@RequestMapping("/depart-monthly-login")
	public BaseDto departmentMonthlyLog(String depart) throws Exception{
        // 임의로 GET을 통해 url에 parameter를 입력하여 결과를 요청
		if(depart==null) depart=" ";
        return service.departMonthLog(depart);
    }
}
