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
import com.thinkgem.jeesite.modules.sys.entity.RightMotorWheelInfo;
import com.thinkgem.jeesite.modules.sys.service.RightMotorWheelInfoService;

/**
 * 右侧电动轮主要参数Controller
 * @author wzy
 * @version 2019-03-09
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/rightMotorWheelInfo")
public class RightMotorWheelInfoController extends BaseController {

	@Autowired
	private RightMotorWheelInfoService rightMotorWheelInfoService;
	
	@ModelAttribute
	public RightMotorWheelInfo get(@RequestParam(required=false) String id) {
		RightMotorWheelInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = rightMotorWheelInfoService.get(id);
		}
		if (entity == null){
			entity = new RightMotorWheelInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:rightMotorWheelInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(RightMotorWheelInfo rightMotorWheelInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<RightMotorWheelInfo> page = rightMotorWheelInfoService.findPage(new Page<RightMotorWheelInfo>(request, response), rightMotorWheelInfo); 
		model.addAttribute("page", page);
		return "modules/sys/rightMotorWheelInfoList";
	}

	@RequiresPermissions("sys:rightMotorWheelInfo:view")
	@RequestMapping(value = "form")
	public String form(RightMotorWheelInfo rightMotorWheelInfo, Model model) {
		model.addAttribute("rightMotorWheelInfo", rightMotorWheelInfo);
		return "modules/sys/rightMotorWheelInfoForm";
	}

	@RequiresPermissions("sys:rightMotorWheelInfo:edit")
	@RequestMapping(value = "save")
	public String save(RightMotorWheelInfo rightMotorWheelInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, rightMotorWheelInfo)){
			return form(rightMotorWheelInfo, model);
		}
		rightMotorWheelInfoService.save(rightMotorWheelInfo);
		addMessage(redirectAttributes, "保存右侧电动轮主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/rightMotorWheelInfo/?repage";
	}
	
	@RequiresPermissions("sys:rightMotorWheelInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(RightMotorWheelInfo rightMotorWheelInfo, RedirectAttributes redirectAttributes) {
		rightMotorWheelInfoService.delete(rightMotorWheelInfo);
		addMessage(redirectAttributes, "删除右侧电动轮主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/rightMotorWheelInfo/?repage";
	}

}