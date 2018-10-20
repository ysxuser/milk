package com.y.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.y.mapper.MUserInfoMapper;
import com.y.model.MUserInfo;
import com.y.service.IMUserInfoService;
import com.y.util.CommonUtil;



/** 
	      * @author : ysx
	      * @date 创建时间：2018年10月11日 下午5:23:25 
	      * @ClassName: IMUserInfoServiceImpl
	      * @parameter  
	      * @Description: TODO  
	      * @return  
	      */
@Service
public  class IMUserInfoServiceImpl implements IMUserInfoService  {
	
	private Logger logger=Logger.getLogger(IMUserInfoServiceImpl.class);
	@Resource
	 MUserInfoMapper mUserInfoMapper;
	
	CommonUtil util = new CommonUtil();
	public String userLogin(Model model,HttpServletRequest request,HttpSession session) {
		logger.info("用户登录");
		String mobilephone = request.getParameter("mobilephone");
		String pwd = request.getParameter("password");
		
		if(userCheck(mobilephone)){
			try {
				List<MUserInfo> users = mUserInfoMapper.selectUserByMobilephone(mobilephone);
				MUserInfo  user = users.get(0);
				if(user.getPassword()!=null && user.getPassword().equals(pwd)){
					model.addAttribute("mobilephone",mobilephone);
					model.addAttribute("result", "homeone");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return null;
	}

	public int userRegister(Model model,HttpServletRequest request,HttpSession session) {
		logger.info("用户注册");
		String mobilephone = request.getParameter("mobilephone");
		String pwd = request.getParameter("passwd");
		MUserInfo  user = new MUserInfo();
		String usernumber = util.currentTime()+util.Rands(0, 3);
		int result = 0;
		
		if(!userCheck(mobilephone)){
			user.setMobilephone(mobilephone);//手机号
			user.setStatus("0");//
			user.setUsernumber(usernumber); //用户编号 是当前时间加上3位随机数共17位
			user.setPassword(pwd);
			user.setCreationTime(util.currentTimeFormat());//当前时间 字符串形式
			try {
				logger.info("准备插入用户数据");
				result = mUserInfoMapper.insert(user);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	/**
	 * @Title: userCheck
	 * @Description:手机号验证,如果存在手机号返回true,否则false
	 * @return boolean 返回类型 
	 * @author ysx
	 */
	public boolean userCheck(String mobilephone){
		logger.info("手机号验证");
		try {
			List<MUserInfo> users = mUserInfoMapper.selectUserByMobilephone(mobilephone);
			
			if(users!=null){
				return true;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
	
	
}
