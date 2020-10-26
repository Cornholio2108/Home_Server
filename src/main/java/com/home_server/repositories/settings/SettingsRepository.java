package com.home_server.repositories.settings;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home_server.domain.settings.AppSettings;

@Repository
public interface SettingsRepository extends CrudRepository<AppSettings, Long> {

}
