/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.entity.BoxBucketInfo;
import com.thinkgem.jeesite.modules.sys.entity.CarInfo;
import com.thinkgem.jeesite.modules.sys.entity.CharterInfo;
import com.thinkgem.jeesite.modules.sys.entity.EngineInfo;
import com.thinkgem.jeesite.modules.sys.entity.FiveShoeInfo;
import com.thinkgem.jeesite.modules.sys.entity.FourShoeInfo;
import com.thinkgem.jeesite.modules.sys.entity.LeftMotorWheelInfo;
import com.thinkgem.jeesite.modules.sys.entity.MainDynamoInfo;
import com.thinkgem.jeesite.modules.sys.entity.OneShoeInfo;
import com.thinkgem.jeesite.modules.sys.entity.RightMotorWheelInfo;
import com.thinkgem.jeesite.modules.sys.entity.SixShoeInfo;
import com.thinkgem.jeesite.modules.sys.entity.ThreeShoeInfo;
import com.thinkgem.jeesite.modules.sys.entity.TwoShoeInfo;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
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
	@Transactional(readOnly = false)
	public void processExcel(List<CarInfo> carinfos,List<CharterInfo> charterInfos) {
		
		if(null == carinfos || carinfos.size() == 0) {
			return;
		}
		
		if(null == charterInfos || charterInfos.size() == 0) {
			return;
		}
		
		//先处理包机负责人
		processExcelCharterInfo(charterInfos);
		
		//其余各个参数
		for(CarInfo carinfo : carinfos) {
			
			String chareterId = findCharterInfo(carinfo.getMotorcycleType(),carinfo.getSeriaNumber(),charterInfos);
			if(null!=chareterId) {
				carinfo.setCharterId(chareterId);
			}
			processExcelEngineInfo(carinfo.getEngineInfo());
			processExcelMainDynamoInfo(carinfo.getMainDynamoInfo());
			processExcelMainLeftMotorWheelInfo(carinfo.getLeftMonotrwheelInfo());
			processExcelRightMotorWheelInfo(carinfo.getRightMotorWheelInfo());
			processExcelBoxBucketInfo(carinfo.getBoxBucketInfo());
			processExcelOneShoeInfo(carinfo.getOneShoeInfo());
			processExcelTwoShoeInfo(carinfo.getTwoShoeInfo());
			processExcelThreeShoeInfo(carinfo.getThreeShoeInfo());
			processExcelFourShoeInfo(carinfo.getFourShoeInfo());
			processExcelFiveShoeInfo(carinfo.getFiveShoeInfo());
			processExcelSixShoeInfo(carinfo.getSixShoeInfo());
			
			String motorcycleType = carinfo.getMotorcycleType();		// 车型
			String seriaNumber = carinfo.getSeriaNumber();		// 编号
			CarInfo querySame = new CarInfo();
			querySame.setMotorcycleType(motorcycleType);
			querySame.setSeriaNumber(seriaNumber);
			List<CarInfo> results = dao.findList(querySame);
			if(null!=results&&results.size()>0) {
				//更新操作
				CarInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
				origin.setMotorcycleType(carinfo.getMotorcycleType());		// 车型
				origin.setSeriaNumber(carinfo.getSeriaNumber());		// 编号
				origin.setInputTime(carinfo.getInputTime());		// 投入时间
				origin.setRunDate(carinfo.getRunDate());		// 运行时间
				
				
				origin.setEngineParamterId(carinfo.getEngineInfo().getId());		// 发动机主要参数
				origin.setMainDynamoParamterId(carinfo.getMainDynamoInfo().getId());		// 主发电机主要参数
				origin.setLeftMotorWheelParamterId(carinfo.getLeftMonotrwheelInfo().getId());		// 左侧电动轮主要参数
				origin.setRightMotorWheelParamterId(carinfo.getRightMotorWheelInfo().getId());	// 右侧电动轮主要参数
				origin.setBoxBucketParamterId(carinfo.getBoxBucketInfo().getId());// 箱斗主要参数
				origin.setOneShoeId(carinfo.getOneShoeInfo().getId());		// 1#轮胎主要参数
				origin.setTwoShoeId(carinfo.getTwoShoeInfo().getId());	// 2#轮胎主要参数
				origin.setThreeShoeId(carinfo.getThreeShoeInfo().getId());		// 3#轮胎主要参数
				origin.setFourShoeId(carinfo.getFourShoeInfo().getId());	// 4#轮胎主要参数
				origin.setFiveShoeId(carinfo.getFiveShoeInfo().getId());	// 5#轮胎主要参数
				origin.setSixShoeId(carinfo.getSixShoeInfo().getId());		// 6#轮胎主要参数
				origin.setCharterId(carinfo.getCharterId());
				User user = UserUtils.getUser();
				if (StringUtils.isNotBlank(user.getId())){
					origin.setUpdateBy(user); 
				}
				origin.setUpdateDate(new Date());
				dao.update(origin);
			}else {
				//插入操作
				carinfo.setId(IdGen.uuid());
				
				
				carinfo.setEngineParamterId(carinfo.getEngineInfo().getId());		// 发动机主要参数
				carinfo.setMainDynamoParamterId(carinfo.getMainDynamoInfo().getId());		// 主发电机主要参数
				carinfo.setLeftMotorWheelParamterId(carinfo.getLeftMonotrwheelInfo().getId());		// 左侧电动轮主要参数
				carinfo.setRightMotorWheelParamterId(carinfo.getRightMotorWheelInfo().getId());	// 右侧电动轮主要参数
				carinfo.setBoxBucketParamterId(carinfo.getBoxBucketInfo().getId());// 箱斗主要参数
				carinfo.setOneShoeId(carinfo.getOneShoeInfo().getId());		// 1#轮胎主要参数
				carinfo.setTwoShoeId(carinfo.getTwoShoeInfo().getId());	// 2#轮胎主要参数
				carinfo.setThreeShoeId(carinfo.getThreeShoeInfo().getId());		// 3#轮胎主要参数
				carinfo.setFourShoeId(carinfo.getFourShoeInfo().getId());	// 4#轮胎主要参数
				carinfo.setFiveShoeId(carinfo.getFiveShoeInfo().getId());	// 5#轮胎主要参数
				carinfo.setSixShoeId(carinfo.getSixShoeInfo().getId());		// 6#轮胎主要参数
				
				User user = UserUtils.getUser();
				if (StringUtils.isNotBlank(user.getId())){
					carinfo.setUpdateBy(user); 
					carinfo.setCreateBy(user);
				}
				carinfo.setUpdateDate(new Date());
				carinfo.setCreateDate(carinfo.getUpdateDate());
				dao.insert(carinfo);
			}
			
		}
		
		
	}
	
	//包机负责人中筛选
	private String findCharterInfo(String pm,String ps,List<CharterInfo> param) {
		if(null == pm
				||"".equals(pm)
					||null == ps
						||"".equals(ps)
							||null == param){
			return null;
		}
		for(CharterInfo c : param) {
			String motorcycleType = c.getCarInfo().getMotorcycleType();		// 车型
			String seriaNumber = c.getCarInfo().getSeriaNumber();		// 编号
			if(motorcycleType.equals(pm)
					&&seriaNumber.equals(ps)) {
				return c.getCharterId();
			}
		}
		return null;
	}
	//包机负责人
	@Transactional(readOnly = false)
	private void processExcelCharterInfo(List<CharterInfo> param) {
		User user = UserUtils.getUser();
		for(CharterInfo c : param) {
			CarInfo querySame = new CarInfo();
			String motorcycleType = c.getCarInfo().getMotorcycleType();		// 车型
			String seriaNumber = c.getCarInfo().getSeriaNumber();		// 编号
			querySame.setMotorcycleType(motorcycleType);
			querySame.setSeriaNumber(seriaNumber);
			List<CarInfo> results = dao.findList(querySame);
			if(null!=results&&results.size()>0) {
				CarInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
				origin.setCharterId(c.getCharterId());
				if (StringUtils.isNotBlank(user.getId())){
					origin.setUpdateBy(user); 
				}
				origin.setUpdateDate(new Date());
				dao.update(origin);
			}else {
				//插入操作
				c.setId(IdGen.uuid());
				if (StringUtils.isNotBlank(user.getId())){
					c.setUpdateBy(user); 
					c.setCreateBy(user);
				}
				c.setUpdateDate(new Date());
				c.setCreateDate(c.getUpdateDate());
				charterInfoDao.insert(c);
			}
		}
	}

	//发动机主要参数
	@Transactional(readOnly = false)
	private void processExcelEngineInfo(EngineInfo param) {
		String zcjxlh = param.getZcjxlh();
		EngineInfo query = new EngineInfo();
		query.setZcjxlh(zcjxlh);
		List<EngineInfo> results = engineInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			EngineInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setYwxcs(param.getYwxcs());		// 已维修次数
			origin.setZbxs(param.getZbxs());		// 质保小时
			origin.setMqsyxs(param.getMqsyxs());	// 目前使用小时
			origin.setWxcj(param.getWxcj());		// 维修厂家
			origin.setWxyy(param.getWxyy());	// 维修原因
			origin.setBltrsyrq(param.getBltrsyrq());		// 本轮投入使用日期
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			engineInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			engineInfoDao.insert(param);
		}
	}

	//主发电机主要参数
	@Transactional(readOnly = false)
	private void processExcelMainDynamoInfo(MainDynamoInfo param) {
		String zcjxlh = param.getZcjxlh();
		MainDynamoInfo query = new MainDynamoInfo();
		query.setZcjxlh(zcjxlh);
		List<MainDynamoInfo> results = mainDynamoInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			MainDynamoInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setYwxcs(param.getYwxcs());		// 已维修次数
			origin.setZbxs(param.getZbxs());		// 质保小时
			origin.setMqsyxs(param.getMqsyxs());	// 目前使用小时
			origin.setWxcj(param.getWxcj());		// 维修厂家
			origin.setWxyy(param.getWxyy());	// 维修原因
			origin.setBltrsyrq(param.getBltrsyrq());		// 本轮投入使用日期
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			mainDynamoInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			mainDynamoInfoDao.insert(param);
		}
	}

	//左侧电动轮主要参数
	@Transactional(readOnly = false)
	private void processExcelMainLeftMotorWheelInfo(LeftMotorWheelInfo param) {
		String zcjxlh = param.getZcjxlh();
		LeftMotorWheelInfo query = new LeftMotorWheelInfo();
		query.setZcjxlh(zcjxlh);
		List<LeftMotorWheelInfo> results = leftMotorWheelInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			LeftMotorWheelInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setYwxcs(param.getYwxcs());		// 已维修次数
			origin.setZbxs(param.getZbxs());		// 质保小时
			origin.setMqsyxs(param.getMqsyxs());	// 目前使用小时
			origin.setWxcj(param.getWxcj());		// 维修厂家
			origin.setWxyy(param.getWxyy());	// 维修原因
			origin.setBltrsyrq(param.getBltrsyrq());		// 本轮投入使用日期
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			leftMotorWheelInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			leftMotorWheelInfoDao.insert(param);
		}
	}

	//右侧电动轮主要参数
	@Transactional(readOnly = false)
	private void processExcelRightMotorWheelInfo(RightMotorWheelInfo param) {
		String zcjxlh = param.getZcjxlh();
		RightMotorWheelInfo query = new RightMotorWheelInfo();
		query.setZcjxlh(zcjxlh);
		List<RightMotorWheelInfo> results = rightMotorWheelInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			RightMotorWheelInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setYwxcs(param.getYwxcs());		// 已维修次数
			origin.setZbxs(param.getZbxs());		// 质保小时
			origin.setMqsyxs(param.getMqsyxs());	// 目前使用小时
			origin.setWxcj(param.getWxcj());		// 维修厂家
			origin.setWxyy(param.getWxyy());	// 维修原因
			origin.setBltrsyrq(param.getBltrsyrq());		// 本轮投入使用日期
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			rightMotorWheelInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			rightMotorWheelInfoDao.insert(param);
		}
	}

	//箱斗主要参数
	@Transactional(readOnly = false)
	private void processExcelBoxBucketInfo(BoxBucketInfo param) {
		String zcjxlh = param.getZcjxlh();
		BoxBucketInfo query = new BoxBucketInfo();
		query.setZcjxlh(zcjxlh);
		List<BoxBucketInfo> results = boxBucketInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			BoxBucketInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setYwxcs(param.getYwxcs());		// 已维修次数
			origin.setZbxs(param.getZbxs());		// 质保小时
			origin.setMqsyxs(param.getMqsyxs());	// 目前使用小时
			origin.setWxcj(param.getWxcj());		// 维修厂家
			origin.setWxyy(param.getWxyy());	// 维修原因
			origin.setBltrsyrq(param.getBltrsyrq());		// 本轮投入使用日期
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			boxBucketInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			boxBucketInfoDao.insert(param);
		}
	}

	//1#轮胎主要参数
	@Transactional(readOnly = false)
	private void processExcelOneShoeInfo(OneShoeInfo param) {
		String xlh = param.getXlh();
		OneShoeInfo query = new OneShoeInfo();
		query.setXlh(xlh);
		List<OneShoeInfo> results = oneShoeInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			OneShoeInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setHwlx(param.getHwlx());;		// 花纹类型
			origin.setLtxh(param.getLtxh());;		// 轮胎型号
			origin.setXfcs(param.getXfcs());;		// 修复次数
			origin.setSysj(param.getSysj());;		// 使用时间
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			oneShoeInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			oneShoeInfoDao.insert(param);
		}
	}

	//2#轮胎主要参数
	@Transactional(readOnly = false)
	private void processExcelTwoShoeInfo(TwoShoeInfo param) {
		String xlh = param.getXlh();
		TwoShoeInfo query = new TwoShoeInfo();
		query.setXlh(xlh);
		List<TwoShoeInfo> results = twoShoeInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			TwoShoeInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setHwlx(param.getHwlx());;		// 花纹类型
			origin.setLtxh(param.getLtxh());;		// 轮胎型号
			origin.setXfcs(param.getXfcs());;		// 修复次数
			origin.setSysj(param.getSysj());;		// 使用时间
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			twoShoeInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			twoShoeInfoDao.insert(param);
		}
	}

	
	//3#轮胎主要参数
	@Transactional(readOnly = false)
	private void processExcelThreeShoeInfo(ThreeShoeInfo param) {
		String xlh = param.getXlh();
		ThreeShoeInfo query = new ThreeShoeInfo();
		query.setXlh(xlh);
		List<ThreeShoeInfo> results = threeShoeInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			ThreeShoeInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setHwlx(param.getHwlx());;		// 花纹类型
			origin.setLtxh(param.getLtxh());;		// 轮胎型号
			origin.setXfcs(param.getXfcs());;		// 修复次数
			origin.setSysj(param.getSysj());;		// 使用时间
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			threeShoeInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			threeShoeInfoDao.insert(param);
		}
	}

	//4#轮胎主要参数
	@Transactional(readOnly = false)
	private void processExcelFourShoeInfo(FourShoeInfo param) {
		String xlh = param.getXlh();
		FourShoeInfo query = new FourShoeInfo();
		query.setXlh(xlh);
		List<FourShoeInfo> results = fourShoeInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			FourShoeInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setHwlx(param.getHwlx());;		// 花纹类型
			origin.setLtxh(param.getLtxh());;		// 轮胎型号
			origin.setXfcs(param.getXfcs());;		// 修复次数
			origin.setSysj(param.getSysj());;		// 使用时间
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			fourShoeInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			fourShoeInfoDao.insert(param);
		}
	}

	
	//5#轮胎主要参数
	@Transactional(readOnly = false)
	private void processExcelFiveShoeInfo(FiveShoeInfo param) {
		String xlh = param.getXlh();
		FiveShoeInfo query = new FiveShoeInfo();
		query.setXlh(xlh);
		List<FiveShoeInfo> results = fiveShoeInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			FiveShoeInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setHwlx(param.getHwlx());;		// 花纹类型
			origin.setLtxh(param.getLtxh());;		// 轮胎型号
			origin.setXfcs(param.getXfcs());;		// 修复次数
			origin.setSysj(param.getSysj());;		// 使用时间
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			fiveShoeInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			fiveShoeInfoDao.insert(param);
		}
	}
	
	//6#轮胎主要参数
	@Transactional(readOnly = false)
	private void processExcelSixShoeInfo(SixShoeInfo param) {
		String xlh = param.getXlh();
		SixShoeInfo query = new SixShoeInfo();
		query.setXlh(xlh);
		List<SixShoeInfo> results = sixShoeInfoDao.findList(query);
		if(null!=results&&results.size()>0) {
			//更新操作
			SixShoeInfo origin = results.get(0);//原来的数据（只有一条如果出现多条数据，那么有问题）
			origin.setHwlx(param.getHwlx());;		// 花纹类型
			origin.setLtxh(param.getLtxh());;		// 轮胎型号
			origin.setXfcs(param.getXfcs());;		// 修复次数
			origin.setSysj(param.getSysj());;		// 使用时间
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				origin.setUpdateBy(user); 
			}
			origin.setUpdateDate(new Date());
			sixShoeInfoDao.update(origin);
			param.setId(origin.getId());
		}else {
			//插入操作
			param.setId(IdGen.uuid());
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())){
				param.setUpdateBy(user); 
				param.setCreateBy(user);
			}
			param.setUpdateDate(new Date());
			param.setCreateDate(param.getUpdateDate());
			sixShoeInfoDao.insert(param);
		}
	}
	
	//是否是插入
	private boolean judgeInsert(CarInfo carinfo) {
		String motorcycleType = carinfo.getMotorcycleType();		// 车型
		String seriaNumber = carinfo.getSeriaNumber();		// 编号
		CarInfo querySame = new CarInfo();
		querySame.setMotorcycleType(motorcycleType);
		querySame.setSeriaNumber(seriaNumber);
		List<CarInfo> resultCarinfos = dao.findAllList(querySame);
		if(null!=resultCarinfos&&resultCarinfos.size()>0) {
			//更新操作
			return false;
		}else {
			//插入操作
			return true;
		}
	}
}