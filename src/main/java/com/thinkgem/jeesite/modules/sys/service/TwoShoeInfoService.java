/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.TwoShoeInfo;
import com.thinkgem.jeesite.modules.sys.dao.TwoShoeInfoDao;

/**
 * 2#轮胎主要参数Service
 * @author wzy
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class TwoShoeInfoService extends CrudService<TwoShoeInfoDao, TwoShoeInfo> {

	public TwoShoeInfo get(String id) {
		return super.get(id);
	}
	
	public List<TwoShoeInfo> findList(TwoShoeInfo twoShoeInfo) {
		return super.findList(twoShoeInfo);
	}
	
	public Page<TwoShoeInfo> findPage(Page<TwoShoeInfo> page, TwoShoeInfo twoShoeInfo) {
		return super.findPage(page, twoShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(TwoShoeInfo twoShoeInfo) {
		super.save(twoShoeInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(TwoShoeInfo twoShoeInfo) {
		super.delete(twoShoeInfo);
	}
	
}