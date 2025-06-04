package com.hcltech.jobhunt_mongodb.Repository;

import com.hcltech.jobhunt_mongodb.model.JobPost;

import java.util.List;

public interface SearchRepository {

    List<JobPost> findByText(String text);

}
