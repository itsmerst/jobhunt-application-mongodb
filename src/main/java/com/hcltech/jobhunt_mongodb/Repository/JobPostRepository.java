package com.hcltech.jobhunt_mongodb.Repository;

import com.hcltech.jobhunt_mongodb.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost,String>
{

}
