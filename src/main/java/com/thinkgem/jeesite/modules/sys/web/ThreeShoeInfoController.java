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
import com.thinkgem.jeesite.modules.sys.entity.ThreeShoeInfo;
import com.thinkgem.jeesite.modules.sys.service.ThreeShoeInfoService;

/**
 * 3#轮胎主要参数Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/threeShoeInfo")
public class ThreeShoeInfoController extends BaseController {

	@Autowired
	private ThreeShoeInfoService threeShoeInfoService;
	
	@ModelAttribute
	public ThreeShoeInfo get(@RequestParam(required=false) String id) {
		ThreeShoeInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = threeShoeInfoService.get(id);
		}
		if (entity == null){
			entity = new ThreeShoeInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:threeShoeInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(ThreeShoeInfo threeShoeInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ThreeShoeInfo> page = threeShoeInfoService.findPage(new Page<ThreeShoeInfo>(request, response), threeShoeInfo); 
		model.addAttribute("page", page);
		return "modules/sys/threeShoeInfoList";
	}

	@RequiresPermissions("sys:threeShoeInfo:view")
	@RequestMapping(value = "form")
	public String form(ThreeShoeInfo threeShoeInfo, Model model) {
		model.addAttribute("threeShoeInfo", threeShoeInfo);
		return "modules/sys/threeShoeInfoForm";
	}

	@RequiresPermissions("sys:threeShoeInfo:edit")
	@RequestMapping(value = "save")
	public String save(ThreeShoeInfo threeShoeInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, threeShoeInfo)){
			return form(threeShoeInfo, model);
		}
		threeShoeInfoService.save(threeShoeInfo);
		addMessage(redirectAttributes, "保存3#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/threeShoeInfo/?repage";
	}
	
	@RequiresPermissions("sys:threeShoeInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(ThreeShoeInfo threeShoeInfo, RedirectAttributes redirectAttributes) {
		threeShoeInfoService.delete(threeShoeInfo);
		addMessage(redirectAttributes, "删除3#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/threeShoeInfo/?repage";
	}

}