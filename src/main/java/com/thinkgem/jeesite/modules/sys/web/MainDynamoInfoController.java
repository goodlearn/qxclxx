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
import com.thinkgem.jeesite.modules.sys.entity.MainDynamoInfo;
import com.thinkgem.jeesite.modules.sys.service.MainDynamoInfoService;

/**
 * 主发电机主要参数Controller
 * @author wzy
 * @version 2019-03-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/mainDynamoInfo")
public class MainDynamoInfoController extends BaseController {

	@Autowired
	private MainDynamoInfoService mainDynamoInfoService;
	
	@ModelAttribute
	public MainDynamoInfo get(@RequestParam(required=false) String id) {
		MainDynamoInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = mainDynamoInfoService.get(id);
		}
		if (entity == null){
			entity = new MainDynamoInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:mainDynamoInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(MainDynamoInfo mainDynamoInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MainDynamoInfo> page = mainDynamoInfoService.findPage(new Page<MainDynamoInfo>(request, response), mainDynamoInfo); 
		model.addAttribute("page", page);
		return "modules/sys/mainDynamoInfoList";
	}

	@RequiresPermissions("sys:mainDynamoInfo:view")
	@RequestMapping(value = "form")
	public String form(MainDynamoInfo mainDynamoInfo, Model model) {
		model.addAttribute("mainDynamoInfo", mainDynamoInfo);
		return "modules/sys/mainDynamoInfoForm";
	}

	@RequiresPermissions("sys:mainDynamoInfo:edit")
	@RequestMapping(value = "save")
	public String save(MainDynamoInfo mainDynamoInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, mainDynamoInfo)){
			return form(mainDynamoInfo, model);
		}
		mainDynamoInfoService.save(mainDynamoInfo);
		addMessage(redirectAttributes, "保存主发电机主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/mainDynamoInfo/?repage";
	}
	
	@RequiresPermissions("sys:mainDynamoInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(MainDynamoInfo mainDynamoInfo, RedirectAttributes redirectAttributes) {
		mainDynamoInfoService.delete(mainDynamoInfo);
		addMessage(redirectAttributes, "删除主发电机主要参数成功");
		return "redirect:"+Global.getAdminPath()+"/sys/mainDynamoInfo/?repage";
	}

}