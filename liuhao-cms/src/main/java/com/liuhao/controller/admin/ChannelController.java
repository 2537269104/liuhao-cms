package com.liuhao.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhao.pojo.Channel;
import com.liuhao.service.ChannelService;

@Controller
@RequestMapping("/channel/")
public class ChannelController {

	@Autowired 
	private ChannelService channelService;
	
	
}
