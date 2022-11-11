package com.example.homework.controller;

import com.example.homework.model.Job;
import com.example.homework.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("")
    public List<Job> getAllJob(){
        return jobService.getAllJob();
    }

    @GetMapping("/random")
    public Job getJobRandom(){
        return jobService.getJobRandom();
    }





    @GetMapping("/sort")
    public List<Job> sortJob(@RequestParam(value = "field",defaultValue = "maxSalary") String field,
                                     @RequestParam(value = "direction", defaultValue = "DESC") String direction){
        return jobService.sortJob(field,direction);
    }





}
