package com.hcltech.jobhunt_mongodb.controller;

import com.hcltech.jobhunt_mongodb.Repository.JobPostRepository;
import com.hcltech.jobhunt_mongodb.Repository.SearchRepository;
import com.hcltech.jobhunt_mongodb.model.JobPost;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class JobPostController
{


    @Autowired
    JobPostRepository repo;

    @Autowired
    SearchRepository schrepo;

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

    @PostMapping("/jobpost")
    public JobPost addJobPost(@RequestBody JobPost jobpost)
    {
      return repo.save(jobpost);
    }

    //jobposts/java
    @GetMapping("/jobposts/{text}")
    public List<JobPost> search(@PathVariable String text)
    {
        return schrepo.findByText(text);
    }

    @DeleteMapping("/jobposts/{id}")
    public List<JobPost> deletejobpost(@PathVariable String id)
    {
        return schrepo.findByText(id);
    }
}