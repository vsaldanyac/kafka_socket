package com.vic.mstelestolists.repositories;

import com.vic.mstelestolists.entities.BlackList;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BlackListRepository extends MongoRepository<BlackList, String> {
}
