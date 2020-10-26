package com.home_server.application.settings;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home_server.domain.settings.AppSettings;
import com.home_server.domain.shoppinglist.ShoppingListItem;
import com.home_server.repositories.settings.SettingsRepository;
import com.home_server.repositories.shoppinglist.ShoppingListRepository;

@Service
@Transactional
public class SettingsService {
	@Resource
	private SettingsRepository settingsRepository;

	public AppSettings getSettings() {
		List<AppSettings> settingsList = (List<AppSettings>) settingsRepository.findAll();
		if (settingsList.size() > 0)
			return settingsList.get(settingsList.size() - 1);
		else
			return null;
	}

	@Transactional(readOnly = false)
	public AppSettings saveSettings(AppSettings entity) {
		entity = settingsRepository.save(entity);
		return entity;
	}
}
