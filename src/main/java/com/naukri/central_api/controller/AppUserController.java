package com.naukri.central_api.controller;

import com.naukri.central_api.dto.JobSeekerRegistrationDto;
import com.naukri.central_api.dto.JwtTokenResponseDto;
import com.naukri.central_api.dto.LoginDto;
import com.naukri.central_api.exception.UnAuthorizedException;
import com.naukri.central_api.model.AppUser;
import com.naukri.central_api.service.UserService;
import com.naukri.central_api.utility.AuthUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/central/user")
public class AppUserController {

        UserService userService;
        AuthUtil authUtil;

        public AppUserController(UserService userService,  AuthUtil authUtil){
            this.userService = userService;
            this.authUtil = authUtil;
        }

    @PostMapping("/register")
    public ResponseEntity registerJobApplicant(@RequestBody JobSeekerRegistrationDto jobSeekerDto){
            //calling userService
        AppUser user =  userService.registerJobSeeker(jobSeekerDto);
        String token = authUtil.generateToken(user.getEmail(),user.getPassword(),user.getUserType());
        JwtTokenResponseDto tokenResponseDto = new JwtTokenResponseDto(token);

        return new ResponseEntity(tokenResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity userLogin(@RequestBody LoginDto loginDto){
        try{
            String token = authUtil.generateTokenFromLoginDetails(loginDto.getEmail(),loginDto.getPassword());
            return new ResponseEntity(new JwtTokenResponseDto(token), HttpStatus.OK);
        }catch(UnAuthorizedException e){
            return new ResponseEntity(e, HttpStatus.UNAUTHORIZED);
        }
    }

//    @GetMapping("/job/search")
//    public ResponseEntity searchJob(
//            @RequestParam(required = false) String title,
//            @RequestParam(required = false) String company,
//            @RequestParam(required = false) String location
//    ){
//            //call jobService
//
//    }

}
