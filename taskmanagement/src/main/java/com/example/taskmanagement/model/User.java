package com.example.taskmanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String uniqueCode;

    @ManyToMany(mappedBy = "members")
    private Set<Team> teams;

    @OneToMany(mappedBy = "assignee")
    private Set<Task> assignedTasks;

    @OneToMany(mappedBy = "assigner")
    private Set<Task> createdTasks;
}
