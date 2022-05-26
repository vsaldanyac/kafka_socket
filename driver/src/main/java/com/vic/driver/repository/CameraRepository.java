package com.vic.driver.repository;

import com.vic.driver.entities.CameraRead;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CameraRepository extends MongoRepository<CameraRead, String> {

	List<CameraRead> findByPlate();
}
