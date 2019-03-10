/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 车辆信息Entity
 * @author wzy
 * @version 2019-03-10
 */
public class CarInfo extends DataEntity<CarInfo> {
	
	private static final long serialVersionUID = 1L;
	private String motorcycleType;		// 车型
	private String seriaNumber;		// 编号
	private String inputTime;		// 投入时间
	private String runDate;		// 运行时间
	private String charterId;		// 包机负责人
	private String engineParamterId;		// 发动机主要参数
	private String mainDynamoParamterId;		// 主发电机主要参数
	private String leftMotorWheelParamterId;		// 左侧电动轮主要参数
	private String rightMotorWheelParamterId;		// 右侧电动轮主要参数
	private String boxBucketParamterId;		// 箱斗主要参数
	private String oneShoeId;		// 1#轮胎主要参数
	private String twoShoeId;		// 2#轮胎主要参数
	private String threeShoeId;		// 3#轮胎主要参数
	private String fourShoeId;		// 4#轮胎主要参数
	private String fiveShoeId;		// 5#轮胎主要参数
	private String sixShoeId;		// 6#轮胎主要参数
	
	public CarInfo() {
		super();
	}

	public CarInfo(String id){
		super(id);
	}

	@Length(min=0, max=100, message="车型长度必须介于 0 和 100 之间")
	public String getMotorcycleType() {
		return motorcycleType;
	}

	public void setMotorcycleType(String motorcycleType) {
		this.motorcycleType = motorcycleType;
	}
	
	@Length(min=0, max=100, message="编号长度必须介于 0 和 100 之间")
	public String getSeriaNumber() {
		return seriaNumber;
	}

	public void setSeriaNumber(String seriaNumber) {
		this.seriaNumber = seriaNumber;
	}
	
	@Length(min=0, max=100, message="投入时间长度必须介于 0 和 100 之间")
	public String getInputTime() {
		return inputTime;
	}

	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}
	
	@Length(min=0, max=100, message="运行时间长度必须介于 0 和 100 之间")
	public String getRunDate() {
		return runDate;
	}

	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}
	
	@Length(min=0, max=64, message="包机负责人长度必须介于 0 和 64 之间")
	public String getCharterId() {
		return charterId;
	}

	public void setCharterId(String charterId) {
		this.charterId = charterId;
	}
	
	@Length(min=0, max=64, message="发动机主要参数长度必须介于 0 和 64 之间")
	public String getEngineParamterId() {
		return engineParamterId;
	}

	public void setEngineParamterId(String engineParamterId) {
		this.engineParamterId = engineParamterId;
	}
	
	@Length(min=0, max=64, message="主发电机主要参数长度必须介于 0 和 64 之间")
	public String getMainDynamoParamterId() {
		return mainDynamoParamterId;
	}

	public void setMainDynamoParamterId(String mainDynamoParamterId) {
		this.mainDynamoParamterId = mainDynamoParamterId;
	}
	
	@Length(min=0, max=64, message="左侧电动轮主要参数长度必须介于 0 和 64 之间")
	public String getLeftMotorWheelParamterId() {
		return leftMotorWheelParamterId;
	}

	public void setLeftMotorWheelParamterId(String leftMotorWheelParamterId) {
		this.leftMotorWheelParamterId = leftMotorWheelParamterId;
	}
	
	@Length(min=0, max=64, message="右侧电动轮主要参数长度必须介于 0 和 64 之间")
	public String getRightMotorWheelParamterId() {
		return rightMotorWheelParamterId;
	}

	public void setRightMotorWheelParamterId(String rightMotorWheelParamterId) {
		this.rightMotorWheelParamterId = rightMotorWheelParamterId;
	}
	
	@Length(min=0, max=64, message="箱斗主要参数长度必须介于 0 和 64 之间")
	public String getBoxBucketParamterId() {
		return boxBucketParamterId;
	}

	public void setBoxBucketParamterId(String boxBucketParamterId) {
		this.boxBucketParamterId = boxBucketParamterId;
	}
	
	@Length(min=0, max=64, message="1#轮胎主要参数长度必须介于 0 和 64 之间")
	public String getOneShoeId() {
		return oneShoeId;
	}

	public void setOneShoeId(String oneShoeId) {
		this.oneShoeId = oneShoeId;
	}
	
	@Length(min=0, max=64, message="2#轮胎主要参数长度必须介于 0 和 64 之间")
	public String getTwoShoeId() {
		return twoShoeId;
	}

	public void setTwoShoeId(String twoShoeId) {
		this.twoShoeId = twoShoeId;
	}
	
	@Length(min=0, max=64, message="3#轮胎主要参数长度必须介于 0 和 64 之间")
	public String getThreeShoeId() {
		return threeShoeId;
	}

	public void setThreeShoeId(String threeShoeId) {
		this.threeShoeId = threeShoeId;
	}
	
	@Length(min=0, max=64, message="4#轮胎主要参数长度必须介于 0 和 64 之间")
	public String getFourShoeId() {
		return fourShoeId;
	}

	public void setFourShoeId(String fourShoeId) {
		this.fourShoeId = fourShoeId;
	}
	
	@Length(min=0, max=64, message="5#轮胎主要参数长度必须介于 0 和 64 之间")
	public String getFiveShoeId() {
		return fiveShoeId;
	}

	public void setFiveShoeId(String fiveShoeId) {
		this.fiveShoeId = fiveShoeId;
	}
	
	@Length(min=0, max=64, message="6#轮胎主要参数长度必须介于 0 和 64 之间")
	public String getSixShoeId() {
		return sixShoeId;
	}

	public void setSixShoeId(String sixShoeId) {
		this.sixShoeId = sixShoeId;
	}
	
}