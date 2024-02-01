package com.apis.login_analysis.dto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class BaseDto {
	// meta
	private HashMap<String,Object> meta;
	// contents
	private HashMap<String,Object> data;
	
	public BaseDto(int cnt) {
		this.meta = new HashMap<String,Object>();
		LocalDateTime cdt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		this.meta.put("requestTime",cdt.format(formatter));
		this.meta.put("responseTime"," ");
		this.meta.put("totCnt",cnt);
		
		this.data = new HashMap<String,Object>();
	}

	public HashMap<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(HashMap<String, Object> meta) {
		this.meta = meta;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	
}
