package com.example.taskmanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;

    @ManyToOne
    private User teamLead;

    @ManyToMany
    private Set<User> members;

    @OneToMany(mappedBy = "team")
    private Set<Task> tasks;
}
