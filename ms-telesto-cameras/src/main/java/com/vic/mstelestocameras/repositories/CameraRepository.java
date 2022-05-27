package com.vic.mstelestocameras.repositories;

import com.vic.mstelestocameras.entitites.Camera;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CameraRepository extends MongoRepository<Camera, String> {

}
