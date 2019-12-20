package com.liuhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhao.dao.ChannelDao;
import com.liuhao.pojo.Channel;
import com.liuhao.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
 
	@Autowired
	private ChannelDao channelDao;

	@Override
	public List<Channel> selectChannel() {
		// TODO Auto-generated method stub
		return channelDao.selectChannel(null);
	}
	
}
