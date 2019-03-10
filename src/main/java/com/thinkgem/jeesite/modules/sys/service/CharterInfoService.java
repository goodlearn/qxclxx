/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.CharterInfo;
import com.thinkgem.jeesite.modules.sys.dao.CharterInfoDao;

/**
 * 包机负责人信息Service
 * @author wzy
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class CharterInfoService extends CrudService<CharterInfoDao, CharterInfo> {

	public CharterInfo get(String id) {
		return super.get(id);
	}
	
	public List<CharterInfo> findList(CharterInfo charterInfo) {
		return super.findList(charterInfo);
	}
	
	public Page<CharterInfo> findPage(Page<CharterInfo> page, CharterInfo charterInfo) {
		return super.findPage(page, charterInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(CharterInfo charterInfo) {
		super.save(charterInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(CharterInfo charterInfo) {
		super.delete(charterInfo);
	}
	
}