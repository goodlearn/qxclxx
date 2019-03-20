package com.thinkgem.jeesite.modules.sys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

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

/**
* @author wzy
* @version 创建时间：2019年3月10日 下午9:06:41
* @ClassName 类名称
* @Description 类描述
*/
public class ImportExcelCarInfo {
	private  List<CarInfo> carInfoList = new ArrayList<CarInfo>();
	
	private  List<CharterInfo> charterInfos = new ArrayList<CharterInfo>();

	
	

	public List<CarInfo> getCarInfoList() {
		return carInfoList;
	}

	public void setCarInfoList(List<CarInfo> carInfoList) {
		this.carInfoList = carInfoList;
	}

	public  List<CharterInfo> getCharterInfos() {
		return charterInfos;
	}


	/**
     * 读取excel数据
     * @param path
     */
    private  ArrayList<Map<String,String>> readExcelToObj(String path) {

        Workbook wb = null;
        ArrayList<Map<String,String>> result = null;
        try {
            wb = WorkbookFactory.create(new File(path));
            result = readExcel(wb, 0, 2, 0);
            result = readExcel(wb, 1, 2, 0);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public void inputstreamtofile(InputStream ins,File file){
    	OutputStream os;
		try {
			os = new FileOutputStream(file);
			int bytesRead = 0;
    	    byte[] buffer = new byte[8192];
    	    while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
    	       os.write(buffer, 0, bytesRead);
    	    }
    	    os.close();
    	    ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 
    }
    
    /**
     * 读取excel数据
     * @param path
     */
    public  ArrayList<Map<String,String>> readExcelToObj(MultipartFile file) {

        Workbook wb = null;
        ArrayList<Map<String,String>> result = null;
        try {
        	InputStream is = file.getInputStream();
            wb = WorkbookFactory.create(is);
            result = readExcel(wb, 0, 2, 0);
            result = readExcel(wb, 1, 2, 0);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 读取excel文件
     * @param wb
     * @param sheetIndex sheet页下标：从0开始
     * @param startReadLine 开始读取的行:从0开始
     * @param tailLine 去除最后读取的行
     */
    private ArrayList<Map<String,String>> readExcel(Workbook wb,int sheetIndex, int startReadLine, int tailLine) {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = null;
        ArrayList<Map<String,String>> result = new ArrayList<Map<String,String>>();
        for(int i=startReadLine; i<sheet.getLastRowNum()-tailLine+1; i++) {
        	System.out.println(" row is "+i);
            row = sheet.getRow(i);
            
            /**
             * 数据对象创建
             */
            CarInfo carInfo = new CarInfo();
        	
        	EngineInfo engineInfo = new EngineInfo();//发动机
        	MainDynamoInfo mainDynamoInfo = new MainDynamoInfo();//主发动机
        	LeftMotorWheelInfo leftMonotrwheelInfo = new LeftMotorWheelInfo();//左侧电动轮主要参数
        	RightMotorWheelInfo rightMotorWheelInfo = new RightMotorWheelInfo();//右侧电动轮主要参数
        	BoxBucketInfo boxBucketInfo = new BoxBucketInfo();//箱斗主要参数
        	OneShoeInfo oneShoeInfo = new OneShoeInfo();//1#轮胎主要参数
        	TwoShoeInfo twoShoeInfo = new TwoShoeInfo();;//2#轮胎主要参数
        	ThreeShoeInfo threeShoeInfo = new ThreeShoeInfo();//3#轮胎主要参数
        	FourShoeInfo fourShoeInfo = new FourShoeInfo();;//4#轮胎主要参数
        	FiveShoeInfo fiveShoeInfo = new FiveShoeInfo();;//5#轮胎主要参数
        	SixShoeInfo sixShoeInfo = new SixShoeInfo();//6#轮胎主要参数
        	carInfo.setEngineInfo(engineInfo);
        	carInfo.setMainDynamoInfo(mainDynamoInfo);
        	carInfo.setLeftMonotrwheelInfo(leftMonotrwheelInfo);
        	carInfo.setRightMotorWheelInfo(rightMotorWheelInfo);
        	carInfo.setBoxBucketInfo(boxBucketInfo);
        	carInfo.setOneShoeInfo(oneShoeInfo);
        	carInfo.setTwoShoeInfo(twoShoeInfo);
        	carInfo.setThreeShoeInfo(threeShoeInfo);
        	carInfo.setFourShoeInfo(fourShoeInfo);
        	carInfo.setFiveShoeInfo(fiveShoeInfo);
        	carInfo.setSixShoeInfo(sixShoeInfo);
        	CharterInfo charterInfo = new CharterInfo();
        	CarInfo tempCi = new CarInfo();
        	charterInfo.setCarInfo(tempCi);
        	String gsbj = IdGen.uuid();//归属包机
            for(Cell c : row) {
                String returnStr = "";
                boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
                //判断是否具有合并单元格
                if(isMerge) {
                    String rs = getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
                    //System.out.print(rs + "------ ");
                    returnStr = rs;
                }else {
                    //System.out.print(String.valueOf(getCellValue(c))+"++++ ");
                    returnStr = String.valueOf(getCellValue(c));
                }
                System.out.println(" column is "+c.getColumnIndex() + " val is "+getCellValue(c));
                if(sheetIndex == 0) {
                	//数据填充
                    setData(returnStr,c,carInfo);
                }else if(sheetIndex == 1){
                	 if(c.getColumnIndex()==0){
                		 charterInfo.getCarInfo().setMotorcycleType(returnStr); // 车型
                		 charterInfo.setCharterId(gsbj);// 归属包机
                     }else if(c.getColumnIndex()==1){
                    	 charterInfo.getCarInfo().setSeriaNumber(returnStr);// 编号
                     }else if(c.getColumnIndex()==2){
                    	 charterInfo.setProfession(returnStr);;// 工种
                     }else if(c.getColumnIndex()==3){
                    	 charterInfo.setName(returnStr);// 姓名
                     }else if(c.getColumnIndex()==4){
                    	 charterInfo.setContact(returnStr);;// 联系方式
                     }
                	 
                	 String pm = charterInfo.getCarInfo().getMotorcycleType();
            		 String ps = charterInfo.getCarInfo().getSeriaNumber();
                	 if(null!=pm&&null!=ps) {
                		String chareterId = findCharterInfo(pm,ps,charterInfos);
             			if(null!=chareterId) {
             				charterInfo.setCharterId(chareterId);// 归属包机
             			} 
                	 }
                }
            }
            
            //获得数据
            if(sheetIndex == 0) {
            	//数据填充
            	 carInfoList.add(carInfo);
            }else if(sheetIndex == 1){
            	charterInfos.add(charterInfo);
            }
           
        }
        return result;

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
    
    private void setData(String returnStr,Cell c,CarInfo carinfo) {
    	EngineInfo engineInfo = carinfo.getEngineInfo();//发动机
    	MainDynamoInfo mainDynamoInfo = carinfo.getMainDynamoInfo();//主发动机
    	LeftMotorWheelInfo leftMonotrwheelInfo = carinfo.getLeftMonotrwheelInfo();//左侧电动轮主要参数
    	RightMotorWheelInfo rightMotorWheelInfo = carinfo.getRightMotorWheelInfo();//右侧电动轮主要参数
    	BoxBucketInfo boxBucketInfo = carinfo.getBoxBucketInfo();//箱斗主要参数
    	OneShoeInfo oneShoeInfo = carinfo.getOneShoeInfo();//1#轮胎主要参数
    	TwoShoeInfo twoShoeInfo = carinfo.getTwoShoeInfo();//2#轮胎主要参数
    	ThreeShoeInfo threeShoeInfo = carinfo.getThreeShoeInfo();//3#轮胎主要参数
    	FourShoeInfo fourShoeInfo = carinfo.getFourShoeInfo();//4#轮胎主要参数
    	FiveShoeInfo fiveShoeInfo = carinfo.getFiveShoeInfo();//5#轮胎主要参数
    	SixShoeInfo sixShoeInfo = carinfo.getSixShoeInfo();//6#轮胎主要参数
    	
        if(c.getColumnIndex()==0){
        	carinfo.setMotorcycleType(returnStr);// 车型
        }else if(c.getColumnIndex()==1){
        	carinfo.setSeriaNumber(returnStr);// 编号
        }else if(c.getColumnIndex()==2){
        	carinfo.setInputTime(returnStr);// 投入时间
        }else if(c.getColumnIndex()==3){
        	carinfo.setRunDate(returnStr);// 运行时间
        }else if(c.getColumnIndex()==4){
        	engineInfo.setZcjxlh(returnStr);// 总成件序列号
        }else if(c.getColumnIndex()==5){
        	engineInfo.setYwxcs(returnStr);// 已维修次数
        }else if(c.getColumnIndex()==6){
        	engineInfo.setZbxs(returnStr);// 质保小时
        }else if(c.getColumnIndex()==7){
        	engineInfo.setMqsyxs(returnStr);// 目前使用小时
        }else if(c.getColumnIndex()==8){
        	engineInfo.setWxcj(returnStr);// 维修厂家
        }else if(c.getColumnIndex()==9){
        	engineInfo.setWxyy(returnStr);// 维修原因
        }else if(c.getColumnIndex()==10){
        	engineInfo.setBltrsyrq(returnStr);// 本轮投入使用日期
        }else if(c.getColumnIndex()==11){
        	mainDynamoInfo.setZcjxlh(returnStr);// 总成件序列号
        }else if(c.getColumnIndex()==12){
        	mainDynamoInfo.setYwxcs(returnStr);// 已维修次数
        }else if(c.getColumnIndex()==13){
        	mainDynamoInfo.setZbxs(returnStr);// 质保小时
        }else if(c.getColumnIndex()==14){
        	mainDynamoInfo.setMqsyxs(returnStr);// 目前使用小时
        }else if(c.getColumnIndex()==15){
        	mainDynamoInfo.setWxcj(returnStr);// 维修厂家
        }else if(c.getColumnIndex()==16){
        	mainDynamoInfo.setWxyy(returnStr);// 维修原因
        }else if(c.getColumnIndex()==17){
        	mainDynamoInfo.setBltrsyrq(returnStr);// 本轮投入使用日期
        }else if(c.getColumnIndex()==18){
        	leftMonotrwheelInfo.setZcjxlh(returnStr);// 总成件序列号
        }else if(c.getColumnIndex()==19){
        	leftMonotrwheelInfo.setYwxcs(returnStr);// 已维修次数
        }else if(c.getColumnIndex()==20){
        	leftMonotrwheelInfo.setZbxs(returnStr);// 质保小时
        }else if(c.getColumnIndex()==21){
        	leftMonotrwheelInfo.setMqsyxs(returnStr);// 目前使用小时
        }else if(c.getColumnIndex()==22){
        	leftMonotrwheelInfo.setWxcj(returnStr);// 维修厂家
        }else if(c.getColumnIndex()==23){
        	leftMonotrwheelInfo.setWxyy(returnStr);// 维修原因
        }else if(c.getColumnIndex()==24){
        	leftMonotrwheelInfo.setBltrsyrq(returnStr);// 本轮投入使用日期
        }else if(c.getColumnIndex()==25){
        	rightMotorWheelInfo.setZcjxlh(returnStr);// 总成件序列号
        }else if(c.getColumnIndex()==26){
        	rightMotorWheelInfo.setYwxcs(returnStr);// 已维修次数
        }else if(c.getColumnIndex()==27){
        	rightMotorWheelInfo.setZbxs(returnStr);// 质保小时
        }else if(c.getColumnIndex()==28){
        	rightMotorWheelInfo.setMqsyxs(returnStr);// 目前使用小时
        }else if(c.getColumnIndex()==29){
        	rightMotorWheelInfo.setWxcj(returnStr);// 维修厂家
        }else if(c.getColumnIndex()==30){
        	rightMotorWheelInfo.setWxyy(returnStr);// 维修原因
        }else if(c.getColumnIndex()==31){
        	rightMotorWheelInfo.setBltrsyrq(returnStr);// 本轮投入使用日期
        }else if(c.getColumnIndex()==32){
        	boxBucketInfo.setZcjxlh(returnStr);// 总成件序列号
        }else if(c.getColumnIndex()==33){
        	boxBucketInfo.setYwxcs(returnStr);// 已维修次数
        }else if(c.getColumnIndex()==34){
        	boxBucketInfo.setZbxs(returnStr);// 质保小时
        }else if(c.getColumnIndex()==35){
        	boxBucketInfo.setMqsyxs(returnStr);// 目前使用小时
        }else if(c.getColumnIndex()==36){
        	boxBucketInfo.setWxcj(returnStr);// 维修厂家
        }else if(c.getColumnIndex()==37){
        	boxBucketInfo.setWxyy(returnStr);// 维修原因
        }else if(c.getColumnIndex()==38){
        	boxBucketInfo.setBltrsyrq(returnStr);// 本轮投入使用日期
        }else if(c.getColumnIndex()==39){
        	oneShoeInfo.setXlh(returnStr);;// 序列号
        }else if(c.getColumnIndex()==40){
        	oneShoeInfo.setHwlx(returnStr);// 花纹类型
        }else if(c.getColumnIndex()==41){
        	oneShoeInfo.setLtxh(returnStr);// 轮胎型号
        }else if(c.getColumnIndex()==42){
        	oneShoeInfo.setXfcs(returnStr);// 修复次数
        }else if(c.getColumnIndex()==43){
        	oneShoeInfo.setSysj(returnStr);// 使用时间
        }else if(c.getColumnIndex()==44){
        	twoShoeInfo.setXlh(returnStr);;// 序列号
        }else if(c.getColumnIndex()==45){
        	twoShoeInfo.setHwlx(returnStr);// 花纹类型
        }else if(c.getColumnIndex()==46){
        	twoShoeInfo.setLtxh(returnStr);// 轮胎型号
        }else if(c.getColumnIndex()==47){
        	twoShoeInfo.setXfcs(returnStr);// 修复次数
        }else if(c.getColumnIndex()==48){
        	twoShoeInfo.setSysj(returnStr);// 使用时间
        }else if(c.getColumnIndex()==49){
        	threeShoeInfo.setXlh(returnStr);;// 序列号
        }else if(c.getColumnIndex()==50){
        	threeShoeInfo.setHwlx(returnStr);// 花纹类型
        }else if(c.getColumnIndex()==51){
        	threeShoeInfo.setLtxh(returnStr);// 轮胎型号
        }else if(c.getColumnIndex()==52){
        	threeShoeInfo.setXfcs(returnStr);// 修复次数
        }else if(c.getColumnIndex()==53){
        	threeShoeInfo.setSysj(returnStr);// 使用时间
        }else if(c.getColumnIndex()==54){
        	fourShoeInfo.setXlh(returnStr);;// 序列号
        }else if(c.getColumnIndex()==55){
        	fourShoeInfo.setHwlx(returnStr);// 花纹类型
        }else if(c.getColumnIndex()==56){
        	fourShoeInfo.setLtxh(returnStr);// 轮胎型号
        }else if(c.getColumnIndex()==57){
        	fourShoeInfo.setXfcs(returnStr);// 修复次数
        }else if(c.getColumnIndex()==58){
        	fourShoeInfo.setSysj(returnStr);// 使用时间
        }else if(c.getColumnIndex()==59){
        	fiveShoeInfo.setXlh(returnStr);;// 序列号
        }else if(c.getColumnIndex()==60){
        	fiveShoeInfo.setHwlx(returnStr);// 花纹类型
        }else if(c.getColumnIndex()==61){
        	fiveShoeInfo.setLtxh(returnStr);// 轮胎型号
        }else if(c.getColumnIndex()==62){
        	fiveShoeInfo.setXfcs(returnStr);// 修复次数
        }else if(c.getColumnIndex()==63){
        	fiveShoeInfo.setSysj(returnStr);// 使用时间
        }else if(c.getColumnIndex()==64){
        	sixShoeInfo.setXlh(returnStr);;// 序列号
        }else if(c.getColumnIndex()==65){
        	sixShoeInfo.setHwlx(returnStr);// 花纹类型
        }else if(c.getColumnIndex()==66){
        	sixShoeInfo.setLtxh(returnStr);// 轮胎型号
        }else if(c.getColumnIndex()==67){
        	sixShoeInfo.setXfcs(returnStr);// 修复次数
        }else if(c.getColumnIndex()==68){
        	sixShoeInfo.setSysj(returnStr);// 使用时间
        }
    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(Sheet sheet ,int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){

                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }

        return null ;
    }

    /**
     * 判断合并了行
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private boolean isMergedRow(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row == firstRow && row == lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @param column 列下标
     * @return
     */
    private boolean isMergedRegion(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断sheet页中是否含有合并单元格
     * @param sheet
     * @return
     */
    private boolean hasMerged(Sheet sheet) {
        return sheet.getNumMergedRegions() > 0 ? true : false;
    }

    /**
     * 合并单元格
     * @param sheet
     * @param firstRow 开始行
     * @param lastRow 结束行
     * @param firstCol 开始列
     * @param lastCol 结束列
     */
    private void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell){

        if(cell == null) return "";

        if(cell.getCellType() == Cell.CELL_TYPE_STRING){

            return cell.getStringCellValue();

        }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){

            return String.valueOf(cell.getBooleanCellValue());

        }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){

            return cell.getCellFormula() ;

        }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
        	if(String.valueOf(cell.getNumericCellValue()).indexOf("E")==-1){
    	        return String.valueOf(cell.getNumericCellValue());
    	    }else {
    	        return new DecimalFormat("#").format(cell.getNumericCellValue());
    	    }


        }
        return "";
    }
    /**
     * 从excel读取内容
     */
    public void readContent(String fileName)  {
        boolean isE2007 = false;    //判断是否是excel2007格式
        if(fileName.endsWith("xlsx"))
            isE2007 = true;
        try {
            InputStream input = new FileInputStream(fileName);  //建立输入流
            Workbook wb  = null;
            //根据文件格式(2003或者2007)来初始化
            if(isE2007)
                wb = new XSSFWorkbook(input);
            else
                wb = new HSSFWorkbook(input);
            Sheet sheet = wb.getSheetAt(0);     //获得第一个表单
            Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器
            while (rows.hasNext()) {
                Row row = rows.next();  //获得行数据
                System.out.println("Row #" + row.getRowNum());  //获得行号从0开始
                Iterator<Cell> cells = row.cellIterator();    //获得第一行的迭代器
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    System.out.println("Cell #" + cell.getColumnIndex());
                    switch (cell.getCellType()) {   //根据cell中的类型来输出数据
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        default:
                            System.out.println("unsuported sell type======="+cell.getCellType());
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

	
	/**
	 * 获取单元格值
	 * @param row 获取的行
	 * @param column 获取单元格列号
	 * @return 单元格值
	 */
	public Object getCellValue(Row row, int column){
		Object val = "";
		try{
			Cell cell = row.getCell(column);
			if (cell != null){
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					val = cell.getNumericCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_STRING){
					val = cell.getStringCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA){
					val = cell.getCellFormula();
				}else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
					val = cell.getBooleanCellValue();
				}else if (cell.getCellType() == Cell.CELL_TYPE_ERROR){
					val = cell.getErrorCellValue();
				}
			}
		}catch (Exception e) {
			return val;
		}
		return val;
	}
}
