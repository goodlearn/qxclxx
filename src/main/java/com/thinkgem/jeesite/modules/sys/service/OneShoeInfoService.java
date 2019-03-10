/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.OneShoeInfo;
import com.thinkgem.jeesite.modules.sys.dao.OneShoeInfoDao;

/**
 * 1#轮胎主要参数Service
 * @author wzy
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class OneShoeInfoService extends CrudService<OneShoeInfoDao, OneShoeInfo> {

	public OneShoeInfo get(String id) {
		return super.get(id);
	}
	
	public List<OneShoeInfo> findList(OneShoeInfo oneShoeInfo) {
		return super.findList(oneShoeInfo);
	}
	
	public Page<OneShoeInfo> findPage(Page<OneShoeInfo> page, OneShoeInfo oneShoeInfo) {
		return super.findPage(page, oneShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(OneShoeInfo oneShoeInfo) {
		super.save(oneShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(OneShoeInfo oneShoeInfo) {
		super.delete(oneShoeInfo);
	}
	
}