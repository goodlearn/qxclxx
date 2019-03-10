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
import com.thinkgem.jeesite.modules.sys.entity.BoxBucketInfo;
import com.thinkgem.jeesite.modules.sys.service.BoxBucketInfoService;

/**
 * 箱斗主要参数Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/boxBucketInfo")
public class BoxBucketInfoController extends BaseController {

	@Autowired
	private BoxBucketInfoService boxBucketInfoService;
	
	@ModelAttribute
	public BoxBucketInfo get(@RequestParam(required=false) String id) {
		BoxBucketInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = boxBucketInfoService.get(id);
		}
		if (entity == null){
			entity = new BoxBucketInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:boxBucketInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(BoxBucketInfo boxBucketInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BoxBucketInfo> page = boxBucketInfoService.findPage(new Page<BoxBucketInfo>(request, response), boxBucketInfo); 
		model.addAttribute("page", page);
		return "modules/sys/boxBucketInfoList";
	}

	@RequiresPermissions("sys:boxBucketInfo:view")
	@RequestMapping(value = "form")
	public String form(BoxBucketInfo boxBucketInfo, Model model) {
		model.addAttribute("boxBucketInfo", boxBucketInfo);
		return "modules/sys/boxBucketInfoForm";
	}

	@RequiresPermissions("sys:boxBucketInfo:edit")
	@RequestMapping(value = "save")
	public String save(BoxBucketInfo boxBucketInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, boxBucketInfo)){
			return form(boxBucketInfo, model);
		}
		boxBucketInfoService.save(boxBucketInfo);
		addMessage(redirectAttributes, "保存箱斗主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/boxBucketInfo/?repage";
	}
	
	@RequiresPermissions("sys:boxBucketInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(BoxBucketInfo boxBucketInfo, RedirectAttributes redirectAttributes) {
		boxBucketInfoService.delete(boxBucketInfo);
		addMessage(redirectAttributes, "删除箱斗主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/boxBucketInfo/?repage";
	}

}