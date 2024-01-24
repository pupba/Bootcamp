package com.pupba.webapp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.pupba.webapp.dao.StatisticMapper;
import com.pupba.webapp.service.StatisticService;
 
 
 
@Controller
public class webappTest {
    
    @Autowired
    private StatisticService service;
    
    @ResponseBody 
    @RequestMapping("/year")
    public Map<String, Object> sqltest(String year) throws Exception{ 
        // 임의로 GET을 통해 url에 parameter를 입력하여 결과를 요청
        return service.yearloginNum(year);
    }
    
    @RequestMapping("/test") 
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "devfunpj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}