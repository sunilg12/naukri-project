package com.naukri.central_api.service;

import com.naukri.central_api.connectors.DbApiConnector;
import com.naukri.central_api.dto.JobSeekerRegistrationDto;
import com.naukri.central_api.model.AppUser;
import com.naukri.central_api.model.Skill;
import com.naukri.central_api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    SkillService skillService;
    MappingUtility mappingUtility;
    DbApiConnector dbApiConnector;

    @Autowired
    public UserService(SkillService skillService, MappingUtility mappingUtility, DbApiConnector dbApiConnector){
        this.skillService = skillService;
        this.mappingUtility = mappingUtility;
        this.dbApiConnector = dbApiConnector;
    }

    // we need to create model class to map the jobseeker data;
    public AppUser registerJobSeeker(JobSeekerRegistrationDto jobSeekerDto){

        // we need to map jobseekerdto to AppUser
        // we can map here itself or
        //can write mapping class and call here

        List<String> skillNames = jobSeekerDto.getSkillSet();
        List<Skill> skills = skillService.getAllSkills(skillNames);
        AppUser jobSeeker = mappingUtility.mapJobSeekerDetailsToAppUser(jobSeekerDto, skills);
        AppUser user = this.saveAppUser(jobSeeker);
        return user;
    }

    AppUser saveAppUser(AppUser user){
        // this method calls appuser controller of db-Api to save user
        return dbApiConnector.callSaveUserEndpoint(user);
    }
}
