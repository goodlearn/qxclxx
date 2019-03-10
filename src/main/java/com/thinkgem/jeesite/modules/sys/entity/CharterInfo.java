package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 包机负责人信息Entity
 * @author wzy
 * @version 2019-03-10
 */
public class CharterInfo extends DataEntity<CharterInfo> {
	
	private static final long serialVersionUID = 1L;
	private String profession;		// 工种
	private String name;		// 姓名
	private String contact;		// 联系方式
	private String charterId;		// 归属包机
	//临时
	private CarInfo carInfo;
	
	public CarInfo getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}

	public CharterInfo() {
		super();
	}

	public CharterInfo(String id){
		super(id);
	}

	@Length(min=0, max=100, message="工种长度必须介于 0 和 100 之间")
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	@Length(min=0, max=100, message="姓名长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=100, message="联系方式长度必须介于 0 和 100 之间")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Length(min=0, max=64, message="归属包机长度必须介于 0 和 64 之间")
	public String getCharterId() {
		return charterId;
	}

	public void setCharterId(String charterId) {
		this.charterId = charterId;
	}
	
}