package com.example.homework.service;

import com.example.homework.model.Job;
import com.example.homework.request.UpsertJob;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class JobService {
    private List<Job> jobs;

    public JobService(){
        jobs = new ArrayList<>();
        jobs.add(new Job("01","tuyen dung","part time","ha noi",500,1000,"tuananh@gmail.com"));
        jobs.add(new Job("02","tuyen dung","full time","bac ninh",1000,5000,"tuan@gmail.com"));
        jobs.add(new Job("03","tuyen dung","part time","cau giay",600,1500,"tung@gmail.com"));
        jobs.add(new Job("04","tuyen dung","full time","ha dong",500,2000,"hieu@gmail.com"));

    }


    public List<Job> getAllJob() {
        return jobs;
    }
    public Job createJob(UpsertJob request){
        Job job = new Job(request.getId(), request.getTitle(),request.getDescription(),request.getLocation(), request.getMinSalary(), request.getMaxSalary(), request.getEmailTo());

        jobs.add(job);
        return job;
    }
    public Job updateJob(String id, UpsertJob request){
        for (Job job : jobs){
            if (job.getId().equals(id)){
                job.setTitle(request.getTitle());
                job.setDescription(request.getDescription());
                job.setLocation(request.getLocation());
                job.setMinSalary(request.getMinSalary());
                job.setMaxSalary(request.getMaxSalary());
                job.setEmailTo(request.getEmailTo());

                return job;
            }
        }
        return null;
    }
    public void deleteJob(String id){
        for (Job job : jobs){
            if (job.getId().equals(id)){
                jobs.remove(job);
            }
        }

    }



    public Job getJobRandom(){
        int id = new Random().nextInt(jobs.size());
        return jobs.get(id);
    }

    public List<Job> sortJob(String field, String direction){
        if(field.equalsIgnoreCase("maxSalary")){
            if(direction.equalsIgnoreCase("ADSC")){
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary)).toList();
            }else {
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary).reversed()).toList();
            }
        }else {
            return null;
        }
    }
}

