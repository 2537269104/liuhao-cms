package com.liuhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liuhao.dao.SettingsDao;
import com.liuhao.pojo.Settings;
import com.liuhao.service.SettingsService;
@Transactional
@Service
public class SettingsServiceImpl implements SettingsService {

	@Autowired
	private SettingsDao  settingsDao;

	@SuppressWarnings("unused")
	@Override
	public Settings getSettings() {
		//先查询settings表中是否有数据，如果没有，则赋值为空,如果有，则赋值为第一条
		List<Settings> settingsList = settingsDao.selectSettings(null);
		
		if(settingsList.size()==0 || settingsList==null) {
			Settings settings = new Settings();
			settingsDao.insert(settings);
			return settings;
		}
		
		return settingsList.get(0);	
		
	}

	@Override
	public boolean saveSettings(Settings settings) {
		
		
		//只修改网站域名以及网站名称 
		
		return  settingsDao.updateDomainAndNameById(settings)>0;
	}
	
	
}
