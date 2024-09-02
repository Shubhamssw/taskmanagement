package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
