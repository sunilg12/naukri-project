package com.naukri.central_api.connectors;

import com.naukri.central_api.model.AppUser;
import com.naukri.central_api.model.Skill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class DbApiConnector {
    // we need to call database Api endpoints from this class to write calling methods

    @Value("${database.api.baseurl}")
    String baseUrl;

    public Skill callGetSkillByNameEndpoint(String skillName){
        // in this method we will call getBySkillName endpoint from dbApi;
        // create url
        String url = baseUrl + "/skill/get/" + skillName;
        //creation of request
        RequestEntity request = RequestEntity.get(url).build();
        // Use rest template to hit the url of api
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Skill> response = restTemplate.exchange(url, HttpMethod.GET, request, Skill.class);

        return response.getBody();
    }

    public AppUser callSaveUserEndpoint(AppUser user){

        String url = baseUrl + "/user/save";
        RequestEntity request = RequestEntity.post(url).body(user);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AppUser> response = restTemplate.exchange(url,HttpMethod.POST, request, AppUser.class);

        return response.getBody();
    }

    public Skill callSaveSkillEndpoint(Skill skill){

        String url = baseUrl + "/skill/save";
        RequestEntity request = RequestEntity.post(url).body(skill);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Skill> response = restTemplate.exchange(url, HttpMethod.POST, request, Skill.class);

        return response.getBody();
    }
}
