/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.modules.sys.entity.CarInfo;
import com.thinkgem.jeesite.modules.sys.service.CarInfoService;
import com.thinkgem.jeesite.modules.sys.utils.ImportExcelCarInfo;

/**
 * 车辆信息Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/carInfo")
public class CarInfoController extends BaseController {

	@Autowired
	private CarInfoService carInfoService;
	
	@ModelAttribute
	public CarInfo get(@RequestParam(required=false) String id) {
		CarInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = carInfoService.get(id);
		}
		if (entity == null){
			entity = new CarInfo();
		}
		return entity;
	}
	
	/**
	 * 查看详细信息
	 * @param carInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:carInfo:view")
	@RequestMapping(value = {"detail"})
	public String detail(CarInfo carInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		CarInfo result = carInfoService.getDetailInfo(carInfo.getId());
		model.addAttribute("carInfo", result);
		return "modules/sys/carInfoDetail";
	}
	
	
	@RequiresPermissions("sys:carInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(CarInfo carInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CarInfo> page = carInfoService.findPage(new Page<CarInfo>(request, response), carInfo); 
		model.addAttribute("page", page);
		return "modules/sys/carInfoList";
	}
	

	@RequiresPermissions("sys:carInfo:view")
	@RequestMapping(value = "form")
	public String form(CarInfo carInfo, Model model) {
		model.addAttribute("carInfo", carInfo);
		return "modules/sys/carInfoForm";
	}

	@RequiresPermissions("sys:carInfo:edit")
	@RequestMapping(value = "save")
	public String save(CarInfo carInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, carInfo)){
			return form(carInfo, model);
		}
		carInfoService.save(carInfo);
		addMessage(redirectAttributes, "保存车辆信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/carInfo/?repage";
	}
	
	@RequiresPermissions("sys:carInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(CarInfo carInfo, RedirectAttributes redirectAttributes) {
		carInfoService.delete(carInfo);
		addMessage(redirectAttributes, "删除车辆信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/carInfo/?repage";
	}
	
	@RequiresPermissions("sys:carInfo:edit")
	@RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:"+Global.getAdminPath()+"/sys/carInfo/?repage";
		}
		try {
			ImportExcelCarInfo ieci = new ImportExcelCarInfo(); 
			ieci.readExcelToObj(file);
			carInfoService.processExcel(ieci.getCarInfoList(), ieci.getCharterInfos());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:"+Global.getAdminPath()+"/sys/carInfo/?repage";
	}

}