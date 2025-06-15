package com.naukri.database_api.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String state;

    @Column(nullable = false)
    String smallDescription;

    @Column(nullable = false)
    String location;

    @Column(nullable = false)
    String jobDescription;

    @OneToOne
    ApplicationForm aplicationForm;

    @ManyToOne
    AppUser createdBy; // this is the recruiter who created job

    @CreationTimestamp
    LocalDateTime postedDate;

    int totalApplicants;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @ManyToMany
    List<Skill> skills;

    @ManyToMany
    List<FormSubmissions> jobApplicants;
}
