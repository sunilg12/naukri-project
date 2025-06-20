package com.naukri.central_api.utility;

import com.naukri.central_api.dto.JobSeekerRegistrationDto;
import com.naukri.central_api.model.AppUser;
import com.naukri.central_api.model.Skill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingUtility {


    public AppUser mapJobSeekerDetailsToAppUser(JobSeekerRegistrationDto jobSeekerDto, List<Skill> skills){
        AppUser appUser = new AppUser();
        appUser.setUserType("JOB_SEEKER");
        appUser.setName(jobSeekerDto.getName());
        appUser.setEmail(jobSeekerDto.getEmail());
        appUser.setPassword(jobSeekerDto.getPassword());
        appUser.setPhoneNumber(jobSeekerDto.getPhoneNumber());
        //to get List<Skill> from  List<String>
        appUser.setSkillSet(skills);

        return appUser;
    }
}
