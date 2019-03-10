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
import com.thinkgem.jeesite.modules.sys.entity.SixShoeInfo;
import com.thinkgem.jeesite.modules.sys.service.SixShoeInfoService;

/**
 * 6#轮胎主要参数Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sixShoeInfo")
public class SixShoeInfoController extends BaseController {

	@Autowired
	private SixShoeInfoService sixShoeInfoService;
	
	@ModelAttribute
	public SixShoeInfo get(@RequestParam(required=false) String id) {
		SixShoeInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sixShoeInfoService.get(id);
		}
		if (entity == null){
			entity = new SixShoeInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sixShoeInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(SixShoeInfo sixShoeInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SixShoeInfo> page = sixShoeInfoService.findPage(new Page<SixShoeInfo>(request, response), sixShoeInfo); 
		model.addAttribute("page", page);
		return "modules/sys/sixShoeInfoList";
	}

	@RequiresPermissions("sys:sixShoeInfo:view")
	@RequestMapping(value = "form")
	public String form(SixShoeInfo sixShoeInfo, Model model) {
		model.addAttribute("sixShoeInfo", sixShoeInfo);
		return "modules/sys/sixShoeInfoForm";
	}

	@RequiresPermissions("sys:sixShoeInfo:edit")
	@RequestMapping(value = "save")
	public String save(SixShoeInfo sixShoeInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sixShoeInfo)){
			return form(sixShoeInfo, model);
		}
		sixShoeInfoService.save(sixShoeInfo);
		addMessage(redirectAttributes, "保存6#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sixShoeInfo/?repage";
	}
	
	@RequiresPermissions("sys:sixShoeInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(SixShoeInfo sixShoeInfo, RedirectAttributes redirectAttributes) {
		sixShoeInfoService.delete(sixShoeInfo);
		addMessage(redirectAttributes, "删除6#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sixShoeInfo/?repage";
	}

}