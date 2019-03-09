/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.MainDynamoInfo;
import com.thinkgem.jeesite.modules.sys.dao.MainDynamoInfoDao;

/**
 * 主发电机主要参数Service
 * @author wzy
 * @version 2019-03-09
 */
@Service
@Transactional(readOnly = true)
public class MainDynamoInfoService extends CrudService<MainDynamoInfoDao, MainDynamoInfo> {

	public MainDynamoInfo get(String id) {
		return super.get(id);
	}
	
	public List<MainDynamoInfo> findList(MainDynamoInfo mainDynamoInfo) {
		return super.findList(mainDynamoInfo);
	}
	
	public Page<MainDynamoInfo> findPage(Page<MainDynamoInfo> page, MainDynamoInfo mainDynamoInfo) {
		return super.findPage(page, mainDynamoInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(MainDynamoInfo mainDynamoInfo) {
		super.save(mainDynamoInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(MainDynamoInfo mainDynamoInfo) {
		super.delete(mainDynamoInfo);
	}
	
}