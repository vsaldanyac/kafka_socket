package com.vic.mstelestolists.repositories;

import com.vic.mstelestolists.entities.WhiteList;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface WhiteListRepository extends MongoRepository<WhiteList, String>  {
}
