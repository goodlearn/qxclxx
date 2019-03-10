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
import com.thinkgem.jeesite.modules.sys.entity.FiveShoeInfo;
import com.thinkgem.jeesite.modules.sys.service.FiveShoeInfoService;

/**
 * 5#轮胎主要参数Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/fiveShoeInfo")
public class FiveShoeInfoController extends BaseController {

	@Autowired
	private FiveShoeInfoService fiveShoeInfoService;
	
	@ModelAttribute
	public FiveShoeInfo get(@RequestParam(required=false) String id) {
		FiveShoeInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fiveShoeInfoService.get(id);
		}
		if (entity == null){
			entity = new FiveShoeInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:fiveShoeInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(FiveShoeInfo fiveShoeInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FiveShoeInfo> page = fiveShoeInfoService.findPage(new Page<FiveShoeInfo>(request, response), fiveShoeInfo); 
		model.addAttribute("page", page);
		return "modules/sys/fiveShoeInfoList";
	}

	@RequiresPermissions("sys:fiveShoeInfo:view")
	@RequestMapping(value = "form")
	public String form(FiveShoeInfo fiveShoeInfo, Model model) {
		model.addAttribute("fiveShoeInfo", fiveShoeInfo);
		return "modules/sys/fiveShoeInfoForm";
	}

	@RequiresPermissions("sys:fiveShoeInfo:edit")
	@RequestMapping(value = "save")
	public String save(FiveShoeInfo fiveShoeInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fiveShoeInfo)){
			return form(fiveShoeInfo, model);
		}
		fiveShoeInfoService.save(fiveShoeInfo);
		addMessage(redirectAttributes, "保存5#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/fiveShoeInfo/?repage";
	}
	
	@RequiresPermissions("sys:fiveShoeInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(FiveShoeInfo fiveShoeInfo, RedirectAttributes redirectAttributes) {
		fiveShoeInfoService.delete(fiveShoeInfo);
		addMessage(redirectAttributes, "删除5#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/fiveShoeInfo/?repage";
	}

}