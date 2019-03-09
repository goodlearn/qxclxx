/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.ThreeShoeInfo;
import com.thinkgem.jeesite.modules.sys.dao.ThreeShoeInfoDao;

/**
 * 3#轮胎主要参数Service
 * @author wzy
 * @version 2019-03-09
 */
@Service
@Transactional(readOnly = true)
public class ThreeShoeInfoService extends CrudService<ThreeShoeInfoDao, ThreeShoeInfo> {

	public ThreeShoeInfo get(String id) {
		return super.get(id);
	}
	
	public List<ThreeShoeInfo> findList(ThreeShoeInfo threeShoeInfo) {
		return super.findList(threeShoeInfo);
	}
	
	public Page<ThreeShoeInfo> findPage(Page<ThreeShoeInfo> page, ThreeShoeInfo threeShoeInfo) {
		return super.findPage(page, threeShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ThreeShoeInfo threeShoeInfo) {
		super.save(threeShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(ThreeShoeInfo threeShoeInfo) {
		super.delete(threeShoeInfo);
	}
	
}