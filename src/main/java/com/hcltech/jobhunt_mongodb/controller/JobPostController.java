package com.hcltech.jobhunt_mongodb.controller;

import com.hcltech.jobhunt_mongodb.Repository.JobPostRepository;
import com.hcltech.jobhunt_mongodb.model.JobPost;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
public class JobPostController
{


    @Autowired
    JobPostRepository repo;

    @Hidden
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/jobposts")
    public List<JobPost> getAllJobPosts()
    {
        return repo.findAll();
    }
}