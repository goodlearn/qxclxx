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
import com.thinkgem.jeesite.modules.sys.entity.FourShoeInfo;
import com.thinkgem.jeesite.modules.sys.service.FourShoeInfoService;

/**
 * 4#轮胎主要参数Controller
 * @author wzy
 * @version 2019-03-09
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/fourShoeInfo")
public class FourShoeInfoController extends BaseController {

	@Autowired
	private FourShoeInfoService fourShoeInfoService;
	
	@ModelAttribute
	public FourShoeInfo get(@RequestParam(required=false) String id) {
		FourShoeInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fourShoeInfoService.get(id);
		}
		if (entity == null){
			entity = new FourShoeInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:fourShoeInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(FourShoeInfo fourShoeInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FourShoeInfo> page = fourShoeInfoService.findPage(new Page<FourShoeInfo>(request, response), fourShoeInfo); 
		model.addAttribute("page", page);
		return "modules/sys/fourShoeInfoList";
	}

	@RequiresPermissions("sys:fourShoeInfo:view")
	@RequestMapping(value = "form")
	public String form(FourShoeInfo fourShoeInfo, Model model) {
		model.addAttribute("fourShoeInfo", fourShoeInfo);
		return "modules/sys/fourShoeInfoForm";
	}

	@RequiresPermissions("sys:fourShoeInfo:edit")
	@RequestMapping(value = "save")
	public String save(FourShoeInfo fourShoeInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fourShoeInfo)){
			return form(fourShoeInfo, model);
		}
		fourShoeInfoService.save(fourShoeInfo);
		addMessage(redirectAttributes, "保存4#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/fourShoeInfo/?repage";
	}
	
	@RequiresPermissions("sys:fourShoeInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(FourShoeInfo fourShoeInfo, RedirectAttributes redirectAttributes) {
		fourShoeInfoService.delete(fourShoeInfo);
		addMessage(redirectAttributes, "删除4#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/fourShoeInfo/?repage";
	}

}