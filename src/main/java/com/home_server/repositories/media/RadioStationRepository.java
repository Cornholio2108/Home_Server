package com.home_server.repositories.media;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home_server.domain.media.RadioStation;

@Repository
public interface RadioStationRepository extends CrudRepository<RadioStation, Long> {

}
