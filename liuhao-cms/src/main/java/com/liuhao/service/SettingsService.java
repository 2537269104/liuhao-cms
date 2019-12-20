package com.liuhao.service;

import com.liuhao.pojo.Settings;

public interface SettingsService {


	Settings getSettings();


	boolean saveSettings(Settings settings);

}
