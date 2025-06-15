package com.naukri.database_api.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String answer;

    @ManyToOne
    List<Questions> questions;
}
