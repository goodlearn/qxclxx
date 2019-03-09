/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.FourShoeInfo;
import com.thinkgem.jeesite.modules.sys.dao.FourShoeInfoDao;

/**
 * 4#轮胎主要参数Service
 * @author wzy
 * @version 2019-03-09
 */
@Service
@Transactional(readOnly = true)
public class FourShoeInfoService extends CrudService<FourShoeInfoDao, FourShoeInfo> {

	public FourShoeInfo get(String id) {
		return super.get(id);
	}
	
	public List<FourShoeInfo> findList(FourShoeInfo fourShoeInfo) {
		return super.findList(fourShoeInfo);
	}
	
	public Page<FourShoeInfo> findPage(Page<FourShoeInfo> page, FourShoeInfo fourShoeInfo) {
		return super.findPage(page, fourShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(FourShoeInfo fourShoeInfo) {
		super.save(fourShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(FourShoeInfo fourShoeInfo) {
		super.delete(fourShoeInfo);
	}
	
}