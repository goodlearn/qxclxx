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
import com.thinkgem.jeesite.modules.sys.entity.EngineInfo;
import com.thinkgem.jeesite.modules.sys.service.EngineInfoService;

/**
 * 发动机主要参数Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/engineInfo")
public class EngineInfoController extends BaseController {

	@Autowired
	private EngineInfoService engineInfoService;
	
	@ModelAttribute
	public EngineInfo get(@RequestParam(required=false) String id) {
		EngineInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = engineInfoService.get(id);
		}
		if (entity == null){
			entity = new EngineInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:engineInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(EngineInfo engineInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<EngineInfo> page = engineInfoService.findPage(new Page<EngineInfo>(request, response), engineInfo); 
		model.addAttribute("page", page);
		return "modules/sys/engineInfoList";
	}

	@RequiresPermissions("sys:engineInfo:view")
	@RequestMapping(value = "form")
	public String form(EngineInfo engineInfo, Model model) {
		model.addAttribute("engineInfo", engineInfo);
		return "modules/sys/engineInfoForm";
	}

	@RequiresPermissions("sys:engineInfo:edit")
	@RequestMapping(value = "save")
	public String save(EngineInfo engineInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, engineInfo)){
			return form(engineInfo, model);
		}
		engineInfoService.save(engineInfo);
		addMessage(redirectAttributes, "保存发动机主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/engineInfo/?repage";
	}
	
	@RequiresPermissions("sys:engineInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(EngineInfo engineInfo, RedirectAttributes redirectAttributes) {
		engineInfoService.delete(engineInfo);
		addMessage(redirectAttributes, "删除发动机主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/engineInfo/?repage";
	}

}