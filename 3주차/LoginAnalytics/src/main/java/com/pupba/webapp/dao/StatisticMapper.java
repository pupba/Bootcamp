package com.pupba.webapp.dao;

import java.util.HashMap;
 
import com.pupba.webapp.dto.StatisticDto;
 
public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
 
}