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
public class JobPostController {


    @Autowired
    JobPostRepository repo;

    @Autowired
    SearchRepository schrepo;

    @Hidden
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/jobposts")
    public List<JobPost> getAllJobPosts() {
        return repo.findAll();
    }

    @PostMapping("/jobpost")
    public JobPost addJobPost(@RequestBody JobPost jobpost) {
        return repo.save(jobpost);
    }

    //jobposts/java
    @GetMapping("/jobposts/{text}")
    public List<JobPost> search(@PathVariable String text) {
        return schrepo.findByText(text);
    }

    @DeleteMapping("/jobposts/{id}")
    public void deletejobpostById(@PathVariable String id) {
        repo.deleteById(id);
    }

    @PutMapping("/jobposts/{id}")
    public JobPost updateJobPost(@PathVariable String id, @RequestBody JobPost updatedJobPost) {
        return repo.findById(id).map(jobPost -> {
            jobPost.setDesc(updatedJobPost.getDesc());
            jobPost.setExp(updatedJobPost.getExp());
            jobPost.setProfile(updatedJobPost.getProfile());
            jobPost.setTechs(updatedJobPost.getTechs());
            return repo.save(jobPost);
        }).orElseGet(() -> {
            updatedJobPost.setId(id);
            return repo.save(updatedJobPost);
        });
    }
}
