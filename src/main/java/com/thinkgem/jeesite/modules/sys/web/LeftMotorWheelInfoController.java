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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.LeftMotorWheelInfo;
import com.thinkgem.jeesite.modules.sys.service.LeftMotorWheelInfoService;

/**
 * 主发电机主要参数Controller
 * @author wzy
 * @version 2019-03-09
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/leftMotorWheelInfo")
public class LeftMotorWheelInfoController extends BaseController {

	@Autowired
	private LeftMotorWheelInfoService leftMotorWheelInfoService;
	
	@ModelAttribute
	public LeftMotorWheelInfo get(@RequestParam(required=false) String id) {
		LeftMotorWheelInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = leftMotorWheelInfoService.get(id);
		}
		if (entity == null){
			entity = new LeftMotorWheelInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:leftMotorWheelInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(LeftMotorWheelInfo leftMotorWheelInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<LeftMotorWheelInfo> page = leftMotorWheelInfoService.findPage(new Page<LeftMotorWheelInfo>(request, response), leftMotorWheelInfo); 
		model.addAttribute("page", page);
		return "modules/sys/leftMotorWheelInfoList";
	}

	@RequiresPermissions("sys:leftMotorWheelInfo:view")
	@RequestMapping(value = "form")
	public String form(LeftMotorWheelInfo leftMotorWheelInfo, Model model) {
		model.addAttribute("leftMotorWheelInfo", leftMotorWheelInfo);
		return "modules/sys/leftMotorWheelInfoForm";
	}

	@RequiresPermissions("sys:leftMotorWheelInfo:edit")
	@RequestMapping(value = "save")
	public String save(LeftMotorWheelInfo leftMotorWheelInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, leftMotorWheelInfo)){
			return form(leftMotorWheelInfo, model);
		}
		leftMotorWheelInfoService.save(leftMotorWheelInfo);
		addMessage(redirectAttributes, "保存主发电机主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/leftMotorWheelInfo/?repage";
	}
	
	@RequiresPermissions("sys:leftMotorWheelInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(LeftMotorWheelInfo leftMotorWheelInfo, RedirectAttributes redirectAttributes) {
		leftMotorWheelInfoService.delete(leftMotorWheelInfo);
		addMessage(redirectAttributes, "删除主发电机主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/leftMotorWheelInfo/?repage";
	}

}