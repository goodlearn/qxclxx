/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 1#轮胎主要参数Entity
 * @author wzy
 * @version 2019-03-10
 */
public class OneShoeInfo extends DataEntity<OneShoeInfo> {
	
	private static final long serialVersionUID = 1L;
	private String xlh;		// 序列号
	private String hwlx;		// 花纹类型
	private String ltxh;		// 轮胎型号
	private String xfcs;		// 修复次数
	private String sysj;		// 使用时间
	
	public OneShoeInfo() {
		super();
	}

	public OneShoeInfo(String id){
		super(id);
	}

	@Length(min=0, max=100, message="序列号长度必须介于 0 和 100 之间")
	public String getXlh() {
		return xlh;
	}

	public void setXlh(String xlh) {
		this.xlh = xlh;
	}
	
	@Length(min=0, max=100, message="花纹类型长度必须介于 0 和 100 之间")
	public String getHwlx() {
		return hwlx;
	}

	public void setHwlx(String hwlx) {
		this.hwlx = hwlx;
	}
	
	@Length(min=0, max=100, message="轮胎型号长度必须介于 0 和 100 之间")
	public String getLtxh() {
		return ltxh;
	}

	public void setLtxh(String ltxh) {
		this.ltxh = ltxh;
	}
	
	@Length(min=0, max=100, message="修复次数长度必须介于 0 和 100 之间")
	public String getXfcs() {
		return xfcs;
	}

	public void setXfcs(String xfcs) {
		this.xfcs = xfcs;
	}
	
	@Length(min=0, max=100, message="使用时间长度必须介于 0 和 100 之间")
	public String getSysj() {
		return sysj;
	}

	public void setSysj(String sysj) {
		this.sysj = sysj;
	}
	
}