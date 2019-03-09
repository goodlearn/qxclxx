/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 右侧电动轮主要参数Entity
 * @author wzy
 * @version 2019-03-09
 */
public class RightMotorWheelInfo extends DataEntity<RightMotorWheelInfo> {
	
	private static final long serialVersionUID = 1L;
	private String zcjxlh;		// 总成件序列号
	private String ywxcs;		// 已维修次数
	private String zbxs;		// 质保小时
	private String mqsyxs;		// 目前使用小时
	private String wxcj;		// 维修厂家
	private String wxyy;		// 维修原因
	private String bltrsyrq;		// 本轮投入使用日期
	
	public RightMotorWheelInfo() {
		super();
	}

	public RightMotorWheelInfo(String id){
		super(id);
	}

	@Length(min=0, max=100, message="总成件序列号长度必须介于 0 和 100 之间")
	public String getZcjxlh() {
		return zcjxlh;
	}

	public void setZcjxlh(String zcjxlh) {
		this.zcjxlh = zcjxlh;
	}
	
	@Length(min=0, max=100, message="已维修次数长度必须介于 0 和 100 之间")
	public String getYwxcs() {
		return ywxcs;
	}

	public void setYwxcs(String ywxcs) {
		this.ywxcs = ywxcs;
	}
	
	@Length(min=0, max=100, message="质保小时长度必须介于 0 和 100 之间")
	public String getZbxs() {
		return zbxs;
	}

	public void setZbxs(String zbxs) {
		this.zbxs = zbxs;
	}
	
	@Length(min=0, max=100, message="目前使用小时长度必须介于 0 和 100 之间")
	public String getMqsyxs() {
		return mqsyxs;
	}

	public void setMqsyxs(String mqsyxs) {
		this.mqsyxs = mqsyxs;
	}
	
	@Length(min=0, max=100, message="维修厂家长度必须介于 0 和 100 之间")
	public String getWxcj() {
		return wxcj;
	}

	public void setWxcj(String wxcj) {
		this.wxcj = wxcj;
	}
	
	@Length(min=0, max=255, message="维修原因长度必须介于 0 和 255 之间")
	public String getWxyy() {
		return wxyy;
	}

	public void setWxyy(String wxyy) {
		this.wxyy = wxyy;
	}
	
	@Length(min=0, max=100, message="本轮投入使用日期长度必须介于 0 和 100 之间")
	public String getBltrsyrq() {
		return bltrsyrq;
	}

	public void setBltrsyrq(String bltrsyrq) {
		this.bltrsyrq = bltrsyrq;
	}
	
}