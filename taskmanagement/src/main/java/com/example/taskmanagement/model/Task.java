package com.example.taskmanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    @ManyToOne
    private User assignee;

    @ManyToOne
    private User assigner;

    @ManyToOne
    private Team team;
}
