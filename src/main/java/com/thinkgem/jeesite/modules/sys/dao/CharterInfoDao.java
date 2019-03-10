package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.CharterInfo;

/**
 * 包机负责人信息DAO接口
 * @author wzy
 * @version 2019-03-10
 */
@MyBatisDao
public interface CharterInfoDao extends CrudDao<CharterInfo> {
	
}