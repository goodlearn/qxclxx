/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.SixShoeInfo;
import com.thinkgem.jeesite.modules.sys.dao.SixShoeInfoDao;

/**
 * 6#轮胎主要参数Service
 * @author wzy
 * @version 2019-03-09
 */
@Service
@Transactional(readOnly = true)
public class SixShoeInfoService extends CrudService<SixShoeInfoDao, SixShoeInfo> {

	public SixShoeInfo get(String id) {
		return super.get(id);
	}
	
	public List<SixShoeInfo> findList(SixShoeInfo sixShoeInfo) {
		return super.findList(sixShoeInfo);
	}
	
	public Page<SixShoeInfo> findPage(Page<SixShoeInfo> page, SixShoeInfo sixShoeInfo) {
		return super.findPage(page, sixShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(SixShoeInfo sixShoeInfo) {
		super.save(sixShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(SixShoeInfo sixShoeInfo) {
		super.delete(sixShoeInfo);
	}
	
}