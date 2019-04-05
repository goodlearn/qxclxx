package com.thinkgem.jeesite.modules.sys.entity;

import java.util.ArrayList;
import java.util.List;

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
	private String kh;		// 口号
	private String imgurl;		// 图片地址
	
	
	//临时
	private List<CharterInfo> charterInfos;
	private EngineInfo engineInfo;//发动机
	private MainDynamoInfo mainDynamoInfo;//主发动机
	private LeftMotorWheelInfo leftMonotrwheelInfo;//左侧电动轮主要参数
	private RightMotorWheelInfo rightMotorWheelInfo;//右侧电动轮主要参数
	private BoxBucketInfo boxBucketInfo;//箱斗主要参数
	private OneShoeInfo oneShoeInfo;//1#轮胎主要参数
	private TwoShoeInfo twoShoeInfo;//2#轮胎主要参数
	private ThreeShoeInfo threeShoeInfo;//3#轮胎主要参数
	private FourShoeInfo fourShoeInfo;//4#轮胎主要参数
	private FiveShoeInfo fiveShoeInfo;//5#轮胎主要参数
	private SixShoeInfo sixShoeInfo;//6#轮胎主要参数
	
	/**
	 * 向临时对象中添加一条数据
	 * @param charterInfo
	 */
	public void putCharterInfo(CharterInfo charterInfo) {
		if(null == charterInfos) {
			charterInfos = new ArrayList<CharterInfo>();
		}
		charterInfos.add(charterInfo);
	}
	
	
	public EngineInfo getEngineInfo() {
		return engineInfo;
	}

	public void setEngineInfo(EngineInfo engineInfo) {
		this.engineInfo = engineInfo;
	}

	public MainDynamoInfo getMainDynamoInfo() {
		return mainDynamoInfo;
	}

	public void setMainDynamoInfo(MainDynamoInfo mainDynamoInfo) {
		this.mainDynamoInfo = mainDynamoInfo;
	}

	public LeftMotorWheelInfo getLeftMonotrwheelInfo() {
		return leftMonotrwheelInfo;
	}

	public void setLeftMonotrwheelInfo(LeftMotorWheelInfo leftMonotrwheelInfo) {
		this.leftMonotrwheelInfo = leftMonotrwheelInfo;
	}

	public RightMotorWheelInfo getRightMotorWheelInfo() {
		return rightMotorWheelInfo;
	}

	public void setRightMotorWheelInfo(RightMotorWheelInfo rightMotorWheelInfo) {
		this.rightMotorWheelInfo = rightMotorWheelInfo;
	}

	public BoxBucketInfo getBoxBucketInfo() {
		return boxBucketInfo;
	}

	public void setBoxBucketInfo(BoxBucketInfo boxBucketInfo) {
		this.boxBucketInfo = boxBucketInfo;
	}

	public OneShoeInfo getOneShoeInfo() {
		return oneShoeInfo;
	}

	public void setOneShoeInfo(OneShoeInfo oneShoeInfo) {
		this.oneShoeInfo = oneShoeInfo;
	}

	public TwoShoeInfo getTwoShoeInfo() {
		return twoShoeInfo;
	}

	public void setTwoShoeInfo(TwoShoeInfo twoShoeInfo) {
		this.twoShoeInfo = twoShoeInfo;
	}

	public ThreeShoeInfo getThreeShoeInfo() {
		return threeShoeInfo;
	}

	public void setThreeShoeInfo(ThreeShoeInfo threeShoeInfo) {
		this.threeShoeInfo = threeShoeInfo;
	}

	public FourShoeInfo getFourShoeInfo() {
		return fourShoeInfo;
	}

	public void setFourShoeInfo(FourShoeInfo fourShoeInfo) {
		this.fourShoeInfo = fourShoeInfo;
	}

	public FiveShoeInfo getFiveShoeInfo() {
		return fiveShoeInfo;
	}

	public void setFiveShoeInfo(FiveShoeInfo fiveShoeInfo) {
		this.fiveShoeInfo = fiveShoeInfo;
	}

	public SixShoeInfo getSixShoeInfo() {
		return sixShoeInfo;
	}

	public void setSixShoeInfo(SixShoeInfo sixShoeInfo) {
		this.sixShoeInfo = sixShoeInfo;
	}

	public List<CharterInfo> getCharterInfos() {
		return charterInfos;
	}

	public void setCharterInfos(List<CharterInfo> charterInfos) {
		this.charterInfos = charterInfos;
	}

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

	@Length(min=0, max=255, message="图片地址长度必须介于 0 和 255 之间")
	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Length(min=0, max=255, message="口号长度必须介于 0 和 255 之间")
	public String getKh() {
		return kh;
	}

	
	public void setKh(String kh) {
		this.kh = kh;
	}

	
	
}