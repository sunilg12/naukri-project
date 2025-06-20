package com.naukri.central_api.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Company {

    UUID id;

    String companyName;

    String email;

    String webSiteLink;

    String linkedinLink;

    int companySize;

    String industry;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
