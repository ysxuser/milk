package com.y.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

/** 
	      * @author : ysx
	      * @date 创建时间：2018年9月30日 下午1:36:08 
	      * @ClassName: IMUserInfoService
	      * @parameter  
	      * @Description: TODO  
	      * @return  
	      */
public interface IMUserInfoService {
	/**
	 * @Title: userLogin
	 * @Description:用户登录
	 * @return String 返回类型 
	 * @author ysx
	 * @param model 
	 */
	public String userLogin(Model model, HttpServletRequest request,HttpSession session) throws Exception;
	
	/**
	 * @Title: userRegister
	 * @Description:用户注册
	 * @return String 返回类型 
	 * @author ysx
	 * @param session 
	 * @param request 
	 * @param model 
	 */
	public int userRegister(Model model, HttpServletRequest request, HttpSession session) throws Exception;
}
