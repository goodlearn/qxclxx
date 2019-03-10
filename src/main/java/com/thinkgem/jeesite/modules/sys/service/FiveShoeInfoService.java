/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.FiveShoeInfo;
import com.thinkgem.jeesite.modules.sys.dao.FiveShoeInfoDao;

/**
 * 5#轮胎主要参数Service
 * @author wzy
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class FiveShoeInfoService extends CrudService<FiveShoeInfoDao, FiveShoeInfo> {

	public FiveShoeInfo get(String id) {
		return super.get(id);
	}
	
	public List<FiveShoeInfo> findList(FiveShoeInfo fiveShoeInfo) {
		return super.findList(fiveShoeInfo);
	}
	
	public Page<FiveShoeInfo> findPage(Page<FiveShoeInfo> page, FiveShoeInfo fiveShoeInfo) {
		return super.findPage(page, fiveShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(FiveShoeInfo fiveShoeInfo) {
		super.save(fiveShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(FiveShoeInfo fiveShoeInfo) {
		super.delete(fiveShoeInfo);
	}
	
}