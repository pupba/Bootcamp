package com.apis.login_analysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.login_analysis.dto.*;
import com.apis.login_analysis.dao.StatisticMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class StatisticServiceImpl implements StatisticService{
	static String getTime() {
		LocalDateTime cdt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		return cdt.format(formatter);
	}
	static java.sql.Date chgSQLDate(String day){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date;
		try {
			date = format.parse(day);
			return new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new java.sql.Date(-999);
		}
	}
	@Autowired
	private StatisticMapper umapper;
	
	@Override
	public BaseDto monthVisit() {
		try {
			// SQL Query 실행
			List<HashMap<String, Object>> results = umapper.MonthVisit();
			// init meta and create data
			BaseDto retVal = new BaseDto(results.size());
			
			HashMap<String,Object> cur = retVal.getData();
			cur.put("contents",new ArrayList<>());
			// 타입 안정성 경고 사용안함.
			@SuppressWarnings("unchecked")
			ArrayList<MonthVisitDto> cur_ = (ArrayList<MonthVisitDto>)cur.get("contents");  
			
			int page = 0;
			boolean is_end = false;
			for(HashMap<String, Object> item : results) {
				if(page == results.size()-1) {
					is_end = true;
				}
				cur_.add(new MonthVisitDto(page,item.get("year"),item.get("month"),item.get("monthly_visitors"),is_end));
				page+=1;
			}
			cur.put("isSuccess",true);
			retVal.getMeta().put("responseTime",getTime());
			return retVal;
		}
		catch(Exception e) {
			BaseDto retVal = new BaseDto(-999);
			retVal.getData().put("isSuccess",false);
			return retVal;
		}
	}
	@Override
	public BaseDto dayVisit(String day) {
		try {
			// SQL Query 실행
			List<HashMap<String, Object>> results = umapper.DayVisit();
			BaseDto retVal = new BaseDto(results.size());
			HashMap<String,Object> cur = retVal.getData();
			cur.put("contents",new ArrayList<>());
			// 타입 안정성 경고 사용안함.
			@SuppressWarnings("unchecked")
			ArrayList<DayVisitDto> cur_ = (ArrayList<DayVisitDto>)cur.get("contents"); 
			int page = 0;
			boolean is_end = false;
			int match = 0;
			if(day.length() > 0) {
				
				match = 1;
			}
			for(HashMap<String, Object> item : results) {
				if(page == results.size()-1) {
					is_end = true;
				}
				if(match==1 && item.get("login_date").equals(chgSQLDate(day))) { // 날짜값이 입력된 경우.
					cur_.clear();
					cur_.add(new DayVisitDto(page,item.get("login_date"),item.get("daily_visitors"),true));
					break;
				}
				cur_.add(new DayVisitDto(page,item.get("login_date"),item.get("daily_visitors"),is_end));
				page+=1;
			}
			cur.put("isSuccess",true);
			retVal.getMeta().put("responseTime",getTime());
			return retVal;
		}
		catch(Exception e){
			BaseDto retVal = new BaseDto(-999);
			retVal.getData().put("isSuccess",false);
			return retVal;
		}
	}
	@Override
	public BaseDto avgDailyLogin() {
		try {
			// SQL Query 실행
			List<HashMap<String, Object>> results = umapper.AvgDailyLogin();
			// init meta and create data
			BaseDto retVal = new BaseDto(results.size());
			
			HashMap<String,Object> cur = retVal.getData();
			cur.put("contents",new ArrayList<>());
			// 타입 안정성 경고 사용안함.
			@SuppressWarnings("unchecked")
			ArrayList<AvgDailyLoginDto> cur_ = (ArrayList<AvgDailyLoginDto>)cur.get("contents");  
			
			int page = 0;
			boolean is_end = false;
			for(HashMap<String, Object> item : results) {
				if(page == results.size()-1) {
					is_end = true;
				}
				cur_.add(new AvgDailyLoginDto(page,item.get("year"),item.get("average_daily_logins"),is_end));
				page+=1;
			}
			cur.put("isSuccess",true);
			retVal.getMeta().put("responseTime",getTime());
			return retVal;
		}
		catch(Exception e) {
			BaseDto retVal = new BaseDto(-999);
			System.err.println(e);
			return retVal;
		}
	}
	@Override
	public BaseDto weekdayLogin() {
		try {
			// SQL Query 실행
			List<HashMap<String, Object>> results = umapper.WeekdayLogin();
			// init meta and create data
			BaseDto retVal = new BaseDto(results.size());
			
			HashMap<String,Object> cur = retVal.getData();
			cur.put("contents",new ArrayList<>());
			// 타입 안정성 경고 사용안함.
			@SuppressWarnings("unchecked")
			ArrayList<WeekdayLoginDto> cur_ = (ArrayList<WeekdayLoginDto>)cur.get("contents");  
			
			int page = 0;
			boolean is_end = false;
			for(HashMap<String, Object> item : results) {
				if(page == results.size()-1) {
					is_end = true;
				}
				cur_.add(new WeekdayLoginDto(page,item.get("date"),item.get("weekday_login"),is_end));
				page+=1;
			}
			cur.put("isSuccess",true);
			retVal.getMeta().put("responseTime",getTime());
			return retVal;
		}
		catch(Exception e) {
			BaseDto retVal = new BaseDto(-999);
			retVal.getData().put("isSuccess",false);
			return retVal;
		}
	}
	@Override
	public BaseDto departMonthLog(String depart) {
		try {
			// SQL Query 실행
			List<HashMap<String, Object>> results = umapper.DepartMonthLog();
			BaseDto retVal = new BaseDto(results.size());
			HashMap<String,Object> cur = retVal.getData();
			cur.put("contents",new ArrayList<>());
			// 타입 안정성 경고 사용안함.
			@SuppressWarnings("unchecked")
			ArrayList<DepartMonthLogDto> cur_ = (ArrayList<DepartMonthLogDto>)cur.get("contents"); 
			int page = 0;
			boolean is_end = false;
	
			for(HashMap<String, Object> item : results) {
				if(page == results.size()-1) {
					is_end = true;
				}
				if(depart.length() != 1) {
					if(item.get("department").equals(depart)) { // 날짜값이 입력된 경우.
						cur_.add(new DepartMonthLogDto(page,item.get("department"),item.get("year"),item.get("month"),item.get("department_monthly_logins"),is_end));
					}
				}
				else {
					cur_.add(new DepartMonthLogDto(page,item.get("department"),item.get("year"),item.get("month"),item.get("department_monthly_logins"),is_end));
				}
				page+=1;
			}
			if(depart.length() > 0) {
				cur_.get(cur_.size()-1).setEnd(true);
			}
			cur.put("isSuccess",true);
			retVal.getMeta().put("responseTime",getTime());
			return retVal;
		}
		catch(Exception e){
			BaseDto retVal = new BaseDto(-999);
			retVal.getData().put("isSuccess",false);
			return retVal;
		}
	}
}
