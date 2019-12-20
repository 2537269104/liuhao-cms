package com.liuhao.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhao.common.JsonResult;
import com.liuhao.pojo.Settings;
import com.liuhao.service.SettingsService;

@Controller
@RequestMapping("/settings")
public class SettingsController {

	@Autowired
	private SettingsService settingsService;
	
	@ResponseBody
	@RequestMapping("/saveSettings")
	public Object saveSettings(Settings settings) {
		
		boolean result = settingsService.saveSettings(settings);
		if(result) {
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "修改失败");
	}
}
