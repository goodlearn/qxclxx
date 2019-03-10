package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.LeftMotorWheelInfo;

/**
 * 左侧电动轮主要参数DAO接口
 * @author wzy
 * @version 2019-03-10
 */
@MyBatisDao
public interface LeftMotorWheelInfoDao extends CrudDao<LeftMotorWheelInfo> {
	
}