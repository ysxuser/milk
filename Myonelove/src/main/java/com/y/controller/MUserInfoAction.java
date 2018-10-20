package com.y.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.y.mapper.MUserInfoMapper;
import com.y.model.MUserInfo;
import com.y.service.IMUserInfoService;

/** 
	      * @author : ysx
	      * @date 创建时间：2018年9月30日 下午1:23:43 
	      * @ClassName: MUserInfoAction
	      * @parameter  
	      * @Description: TODO  
	      * @return  
	      */
@Controller
@RequestMapping("mUserInfoAction")
public class MUserInfoAction extends BaseAction {
	Logger logger = Logger.getLogger(MUserInfoAction.class);
	
	 @Autowired
	 IMUserInfoService mUserInfoService;
	 
	 
	/**
	 * @Title: loginCheck
	 * @Description: 用户登录
	 * @return String 返回类型 
	 * @author ysx
	 */
	@RequestMapping("login")
	public String loginCheck(Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {

		
		
		try {
			mUserInfoService.userLogin(model,request,session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			logger.info("*****开始******");
//			List<MUserInfo> list = mUserInfoMapper.selectByExample();
//			for(MUserInfo m : list){
//				logger.info(m.toString());
//			}
//			logger.info("*****结束******");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "result";
	}
	
	
	
	@RequestMapping("regUser")
	public String registerUser(Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {

		
		try {
			if(mUserInfoService.userRegister( model, request, session )==1){
				return "login";
			}
			logger.info("正常");
		} catch (Exception e) {
			System.out.println("出现异常");
			e.printStackTrace();
		}
		logger.info("error");
		return "error";
	
	}
	
	
	
}
