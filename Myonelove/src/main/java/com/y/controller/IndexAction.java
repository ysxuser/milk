package com.y.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/** 
	      * @author : ysx
	      * @date 创建时间：2018年10月7日 下午8:57:04 
	      * @ClassName: IndexAction
	      * @parameter  
	      * @Description: TODO  
	      * @return  
	      */
@Controller
@RequestMapping("")
public class IndexAction {

	  @RequestMapping("index")
	    public String list(){
		  
		  System.out.println("index");
		  
	        return "login";
	    }
	
	
	
}


