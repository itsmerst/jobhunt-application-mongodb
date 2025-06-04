package com.hcltech.jobhunt_mongodb.Repository;

import com.hcltech.jobhunt_mongodb.model.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> findByText(String text){

        final List<JobPost> jobposts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("jobhunt");
        MongoCollection<Document> collection = database.getCollection("jobhunt");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("desc","techs","profile")))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));

        result.forEach(doc -> jobposts.add(converter.read(JobPost.class,doc)));

        return jobposts;
    }
}
