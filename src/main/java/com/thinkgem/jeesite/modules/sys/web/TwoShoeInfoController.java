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
import com.thinkgem.jeesite.modules.sys.entity.TwoShoeInfo;
import com.thinkgem.jeesite.modules.sys.service.TwoShoeInfoService;

/**
 * 2#轮胎主要参数Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/twoShoeInfo")
public class TwoShoeInfoController extends BaseController {

	@Autowired
	private TwoShoeInfoService twoShoeInfoService;
	
	@ModelAttribute
	public TwoShoeInfo get(@RequestParam(required=false) String id) {
		TwoShoeInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = twoShoeInfoService.get(id);
		}
		if (entity == null){
			entity = new TwoShoeInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:twoShoeInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(TwoShoeInfo twoShoeInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TwoShoeInfo> page = twoShoeInfoService.findPage(new Page<TwoShoeInfo>(request, response), twoShoeInfo); 
		model.addAttribute("page", page);
		return "modules/sys/twoShoeInfoList";
	}

	@RequiresPermissions("sys:twoShoeInfo:view")
	@RequestMapping(value = "form")
	public String form(TwoShoeInfo twoShoeInfo, Model model) {
		model.addAttribute("twoShoeInfo", twoShoeInfo);
		return "modules/sys/twoShoeInfoForm";
	}

	@RequiresPermissions("sys:twoShoeInfo:edit")
	@RequestMapping(value = "save")
	public String save(TwoShoeInfo twoShoeInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, twoShoeInfo)){
			return form(twoShoeInfo, model);
		}
		twoShoeInfoService.save(twoShoeInfo);
		addMessage(redirectAttributes, "保存2#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/twoShoeInfo/?repage";
	}
	
	@RequiresPermissions("sys:twoShoeInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(TwoShoeInfo twoShoeInfo, RedirectAttributes redirectAttributes) {
		twoShoeInfoService.delete(twoShoeInfo);
		addMessage(redirectAttributes, "删除2#轮胎主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/twoShoeInfo/?repage";
	}

}