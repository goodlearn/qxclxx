/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.CarInfo;
import com.thinkgem.jeesite.modules.sys.entity.CharterInfo;
import com.thinkgem.jeesite.modules.sys.entity.EngineInfo;
import com.thinkgem.jeesite.modules.sys.dao.BoxBucketInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.CarInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.CharterInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.EngineInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.FiveShoeInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.FourShoeInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.LeftMotorWheelInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.MainDynamoInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.OneShoeInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.RightMotorWheelInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.SixShoeInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.ThreeShoeInfoDao;
import com.thinkgem.jeesite.modules.sys.dao.TwoShoeInfoDao;

/**
 * 车辆信息Service
 * @author wzy
 * @version 2019-03-10
 */
@Service
@Transactional(readOnly = true)
public class CarInfoService extends CrudService<CarInfoDao, CarInfo> {
	

	
	
	@Autowired
	private CharterInfoDao charterInfoDao;
	
	@Autowired
	private EngineInfoDao engineInfoDao;
	
	@Autowired
	private MainDynamoInfoDao mainDynamoInfoDao;
	
	@Autowired
	private LeftMotorWheelInfoDao leftMotorWheelInfoDao;
	
	@Autowired
	private RightMotorWheelInfoDao rightMotorWheelInfoDao;
	
	@Autowired
	private BoxBucketInfoDao boxBucketInfoDao;
	
	@Autowired
	private OneShoeInfoDao oneShoeInfoDao;
	
	@Autowired
	private TwoShoeInfoDao twoShoeInfoDao;
	
	@Autowired
	private ThreeShoeInfoDao threeShoeInfoDao;
	
	@Autowired
	private FourShoeInfoDao fourShoeInfoDao;
	
	@Autowired
	private FiveShoeInfoDao fiveShoeInfoDao;
	
	@Autowired
	private SixShoeInfoDao sixShoeInfoDao;
	
	

	public CarInfo get(String id) {
		return super.get(id);
	}
	
	public List<CarInfo> findList(CarInfo carInfo) {
		return super.findList(carInfo);
	}
	
	public Page<CarInfo> findPage(Page<CarInfo> page, CarInfo carInfo) {
		return super.findPage(page, carInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(CarInfo carInfo) {
		super.save(carInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(CarInfo carInfo) {
		super.delete(carInfo);
	}
	
	/**
	 * 查看详细信息，将临时信息补充
	 */
	public CarInfo getDetailInfo(String id) {
		CarInfo carInfo = dao.get(id);
		if(null == carInfo) {
			return null;
		}
		
		//包机负责人信息
		String charterInfoId = carInfo.getCharterId();
		CharterInfo queryCharterInfo = new CharterInfo();
		queryCharterInfo.setCharterId(charterInfoId);
		List<CharterInfo> charterInfos = charterInfoDao.findList(queryCharterInfo);
		carInfo.setCharterInfos(charterInfos);
		
		//发动机主要参数
		String epId = carInfo.getEngineParamterId();
		carInfo.setEngineInfo(engineInfoDao.get(epId));
		
		//主发电机主要参数
		String mdpid = carInfo.getMainDynamoParamterId();
		carInfo.setMainDynamoInfo(mainDynamoInfoDao.get(mdpid));
		
		//左侧电动轮主要参数
		String lmwpid = carInfo.getLeftMotorWheelParamterId();
		carInfo.setLeftMonotrwheelInfo(leftMotorWheelInfoDao.get(lmwpid));
		
		//右侧电动轮主要参数
		String rmwoid = carInfo.getRightMotorWheelParamterId();
		carInfo.setRightMotorWheelInfo(rightMotorWheelInfoDao.get(rmwoid));
		
		//箱斗主要参数
		String bbpid = carInfo.getBoxBucketParamterId();
		carInfo.setBoxBucketInfo(boxBucketInfoDao.get(bbpid));
		
		//1#轮胎主要参数
		String osId = carInfo.getOneShoeId();
		carInfo.setOneShoeInfo(oneShoeInfoDao.get(osId));
		
		//2#轮胎主要参数
		String tsId = carInfo.getTwoShoeId();
		carInfo.setTwoShoeInfo(twoShoeInfoDao.get(tsId));
		
		
		//3#轮胎主要参数
		String thsId = carInfo.getThreeShoeId();
		carInfo.setThreeShoeInfo(threeShoeInfoDao.get(thsId));
		
		//4#轮胎主要参数
		String foursId = carInfo.getFourShoeId();
		carInfo.setFourShoeInfo(fourShoeInfoDao.get(foursId));
		
		//5#轮胎主要参数
		String fivesId = carInfo.getFiveShoeId();
		carInfo.setFiveShoeInfo(fiveShoeInfoDao.get(fivesId));
		
		//6#轮胎主要参数
		String sisId = carInfo.getSixShoeId();
		carInfo.setSixShoeInfo(sixShoeInfoDao.get(sisId));
		
		return carInfo;
	}
	
	
	//分析Excel表格
	public void processExcel() {
		
	}
	
}