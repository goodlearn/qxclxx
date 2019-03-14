package com.thinkgem.jeesite.modules.wx.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thinkgem.jeesite.modules.sys.entity.CarInfo;
import com.thinkgem.jeesite.modules.sys.service.CarInfoService;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;


/**
* @author wzy
* @version 创建时间：2019年3月11日 上午9:18:50
* @ClassName 类名称
* @Description 类描述
*/
@Controller
@RequestMapping(value = "ciwic")
public class CarinfoWebInfoController {

	@Autowired
	private CarInfoService carInfoService;
	
	//错误页面
	private final String WX_ERROR = "modules/wxp/500";
	//二维码页面
	private final String WX_Q_RECORD = "modules/wxp/personQRcode";
	private final String WX_Q_RECORD_INFO = "modules/wxp/personQRcodeInfo";
	protected final String ERR_INFO_NOT_GET = "没有该车辆信息";
	
	/**
	 * 获取二维码信息
	 * @param carInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "qrecord",method=RequestMethod.GET)
	public String qrecord(HttpServletRequest request, HttpServletResponse response, Model model) {
		String id = request.getParameter("id");//车型
		CarInfo result = carInfoService.getDetailInfo(id);
		//String urlContent = "http://x.xlhtszgh.org/bzr/a/login?id="+result.getId();
		String label = DictUtils.getDictLabel("requesturl", "qrcodeurl", "https://x.xlhtszgh.org/qxclxx/ciwic/reqCiQRcode?id=");
		String urlContent = label + result.getId();
		model.addAttribute("carInfo", urlContent);
		return WX_Q_RECORD;
	}
	
	/**
	 * 页面跳转-获取二维码页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/reqCiQRcode",method=RequestMethod.GET)
	public String reqPersonQRcode(HttpServletRequest request, HttpServletResponse response,Model model) {
		String ret = null;
		try {
			String id = request.getParameter("id");//车型
			CarInfo carInfo = carInfoService.get(id);
			
			if(null == carInfo) {
				model.addAttribute("message",ERR_INFO_NOT_GET);
				return WX_ERROR;
			}
			
			model.addAttribute("carInfo",carInfo);
			ret = WX_Q_RECORD_INFO;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ret;
	}
	
}
