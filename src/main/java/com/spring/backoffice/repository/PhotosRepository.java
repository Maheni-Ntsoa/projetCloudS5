package com.spring.backoffice.repository;

import com.spring.backoffice.model.Photos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PhotosRepository extends MongoRepository<Photos, String> {
}
