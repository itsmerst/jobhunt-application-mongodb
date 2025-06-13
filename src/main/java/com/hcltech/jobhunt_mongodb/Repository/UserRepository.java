package com.hcltech.jobhunt_mongodb.Repository;

import com.hcltech.jobhunt_mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}

