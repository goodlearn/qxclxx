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
import com.thinkgem.jeesite.modules.sys.entity.CharterInfo;
import com.thinkgem.jeesite.modules.sys.service.CharterInfoService;

/**
 * 包机负责人信息Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/charterInfo")
public class CharterInfoController extends BaseController {

	@Autowired
	private CharterInfoService charterInfoService;
	
	@ModelAttribute
	public CharterInfo get(@RequestParam(required=false) String id) {
		CharterInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = charterInfoService.get(id);
		}
		if (entity == null){
			entity = new CharterInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:charterInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(CharterInfo charterInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CharterInfo> page = charterInfoService.findPage(new Page<CharterInfo>(request, response), charterInfo); 
		model.addAttribute("page", page);
		return "modules/sys/charterInfoList";
	}

	@RequiresPermissions("sys:charterInfo:view")
	@RequestMapping(value = "form")
	public String form(CharterInfo charterInfo, Model model) {
		model.addAttribute("charterInfo", charterInfo);
		return "modules/sys/charterInfoForm";
	}

	@RequiresPermissions("sys:charterInfo:edit")
	@RequestMapping(value = "save")
	public String save(CharterInfo charterInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, charterInfo)){
			return form(charterInfo, model);
		}
		charterInfoService.save(charterInfo);
		addMessage(redirectAttributes, "保存包机负责人信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/charterInfo/?repage";
	}
	
	@RequiresPermissions("sys:charterInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(CharterInfo charterInfo, RedirectAttributes redirectAttributes) {
		charterInfoService.delete(charterInfo);
		addMessage(redirectAttributes, "删除包机负责人信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/charterInfo/?repage";
	}

}