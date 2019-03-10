/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.BoxBucketInfo;
import com.thinkgem.jeesite.modules.sys.dao.BoxBucketInfoDao;

/**
 * 箱斗主要参数Service
 * @author wzy
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class BoxBucketInfoService extends CrudService<BoxBucketInfoDao, BoxBucketInfo> {

	public BoxBucketInfo get(String id) {
		return super.get(id);
	}
	
	public List<BoxBucketInfo> findList(BoxBucketInfo boxBucketInfo) {
		return super.findList(boxBucketInfo);
	}
	
	public Page<BoxBucketInfo> findPage(Page<BoxBucketInfo> page, BoxBucketInfo boxBucketInfo) {
		return super.findPage(page, boxBucketInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(BoxBucketInfo boxBucketInfo) {
		super.save(boxBucketInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(BoxBucketInfo boxBucketInfo) {
		super.delete(boxBucketInfo);
	}
	
}