/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.LeftMotorWheelInfo;
import com.thinkgem.jeesite.modules.sys.dao.LeftMotorWheelInfoDao;

/**
 * 主发电机主要参数Service
 * @author wzy
 * @version 2019-03-09
 */
@Service
@Transactional(readOnly = true)
public class LeftMotorWheelInfoService extends CrudService<LeftMotorWheelInfoDao, LeftMotorWheelInfo> {

	public LeftMotorWheelInfo get(String id) {
		return super.get(id);
	}
	
	public List<LeftMotorWheelInfo> findList(LeftMotorWheelInfo leftMotorWheelInfo) {
		return super.findList(leftMotorWheelInfo);
	}
	
	public Page<LeftMotorWheelInfo> findPage(Page<LeftMotorWheelInfo> page, LeftMotorWheelInfo leftMotorWheelInfo) {
		return super.findPage(page, leftMotorWheelInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(LeftMotorWheelInfo leftMotorWheelInfo) {
		super.save(leftMotorWheelInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(LeftMotorWheelInfo leftMotorWheelInfo) {
		super.delete(leftMotorWheelInfo);
	}
	
}