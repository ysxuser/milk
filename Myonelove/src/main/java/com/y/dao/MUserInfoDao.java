package com.y.dao;

import java.util.List;

import com.y.model.MUserInfo;

/** 
	      * @author : ysx
	      * @date 创建时间：2018年10月8日 下午7:44:12 
	      * @ClassName: MUserInfoDao
	      * @parameter  
	      * @Description: TODO  
	      * @return  
	      */
public interface MUserInfoDao<T> {

	public List<MUserInfo> selectList(T t) throws Exception;
	
	public int updateUser(T t) throws Exception;
	
	public int insert(T t) throws Exception;
	
	public int delete(String id) throws Exception;
}
