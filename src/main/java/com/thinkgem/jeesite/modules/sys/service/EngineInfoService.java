/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.EngineInfo;
import com.thinkgem.jeesite.modules.sys.dao.EngineInfoDao;

/**
 * 发动机主要参数Service
 * @author wzy
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class EngineInfoService extends CrudService<EngineInfoDao, EngineInfo> {

	public EngineInfo get(String id) {
		return super.get(id);
	}
	
	public List<EngineInfo> findList(EngineInfo engineInfo) {
		return super.findList(engineInfo);
	}
	
	public Page<EngineInfo> findPage(Page<EngineInfo> page, EngineInfo engineInfo) {
		return super.findPage(page, engineInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(EngineInfo engineInfo) {
		super.save(engineInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(EngineInfo engineInfo) {
		super.delete(engineInfo);
	}
	
}