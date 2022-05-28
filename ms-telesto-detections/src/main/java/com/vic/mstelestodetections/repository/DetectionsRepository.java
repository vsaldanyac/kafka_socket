package com.vic.mstelestodetections.repository;

import com.vic.mstelestodetections.entities.CameraRead;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DetectionsRepository extends MongoRepository<CameraRead, String>  {
}
