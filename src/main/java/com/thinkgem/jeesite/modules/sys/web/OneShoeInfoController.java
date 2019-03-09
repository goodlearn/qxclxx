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
import com.thinkgem.jeesite.modules.sys.entity.OneShoeInfo;
import com.thinkgem.jeesite.modules.sys.service.OneShoeInfoService;

/**
 * 1#轮胎主要参数Controller
 * @author wzy
 * @version 2019-03-09
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/oneShoeInfo")
public class OneShoeInfoController extends BaseController {

	@Autowired
	private OneShoeInfoService oneShoeInfoService;
	
	@ModelAttribute
	public OneShoeInfo get(@RequestParam(required=false) String id) {
		OneShoeInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oneShoeInfoService.get(id);
		}
		if (entity == null){
			entity = new OneShoeInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:oneShoeInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(OneShoeInfo oneShoeInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OneShoeInfo> page = oneShoeInfoService.findPage(new Page<OneShoeInfo>(request, response), oneShoeInfo); 
		model.addAttribute("page", page);
		return "modules/sys/oneShoeInfoList";
	}

	@RequiresPermissions("sys:oneShoeInfo:view")
	@RequestMapping(value = "form")
	public String form(OneShoeInfo oneShoeInfo, Model model) {
		model.addAttribute("oneShoeInfo", oneShoeInfo);
		return "modules/sys/oneShoeInfoForm";
	}

	@RequiresPermissions("sys:oneShoeInfo:edit")
	@RequestMapping(value = "save")
	public String save(OneShoeInfo oneShoeInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oneShoeInfo)){
			return form(oneShoeInfo, model);
		}
		oneShoeInfoService.save(oneShoeInfo);
		addMessage(redirectAttributes, "保存1#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/oneShoeInfo/?repage";
	}
	
	@RequiresPermissions("sys:oneShoeInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(OneShoeInfo oneShoeInfo, RedirectAttributes redirectAttributes) {
		oneShoeInfoService.delete(oneShoeInfo);
		addMessage(redirectAttributes, "删除1#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/oneShoeInfo/?repage";
	}

}