/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.RightMotorWheelInfo;
import com.thinkgem.jeesite.modules.sys.dao.RightMotorWheelInfoDao;

/**
 * 右侧电动轮主要参数Service
 * @author wzy
 * @version 2019-03-09
 */
@Service
@Transactional(readOnly = true)
public class RightMotorWheelInfoService extends CrudService<RightMotorWheelInfoDao, RightMotorWheelInfo> {

	public RightMotorWheelInfo get(String id) {
		return super.get(id);
	}
	
	public List<RightMotorWheelInfo> findList(RightMotorWheelInfo rightMotorWheelInfo) {
		return super.findList(rightMotorWheelInfo);
	}
	
	public Page<RightMotorWheelInfo> findPage(Page<RightMotorWheelInfo> page, RightMotorWheelInfo rightMotorWheelInfo) {
		return super.findPage(page, rightMotorWheelInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(RightMotorWheelInfo rightMotorWheelInfo) {
		super.save(rightMotorWheelInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(RightMotorWheelInfo rightMotorWheelInfo) {
		super.delete(rightMotorWheelInfo);
	}
	
}