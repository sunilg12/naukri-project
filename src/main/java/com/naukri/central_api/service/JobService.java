package com.naukri.central_api.service;

import com.naukri.central_api.connectors.DbApiConnector;
import com.naukri.central_api.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    DbApiConnector dbApiConnector;

    public JobService(DbApiConnector dbApiConnector){
        this.dbApiConnector = dbApiConnector;
    }

    public List<Job> searchJobs(String title, String companyName, String location){
        //create SQL auery
    }

    public String createJobSearch(String title, String companyName, String location){
        
    }

    public Job saveJob(Job job){
        return dbApiConnector.callSaveJobEndpoint(job);
    }
}
