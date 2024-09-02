package com.example.taskmanagement;

import com.example.taskmanagement.model.Team;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TeamRepository;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("Shubham");
        user1.setEmail("shubham@gmail.com");
        user1.setPhoneNumber("1234567890");
        user1.setUniqueCode("U123");

        User user2 = new User();
        user2.setFirstName("Jane");
        user2.setEmail("jane@example.com");
        user2.setPhoneNumber("0987654321");
        user2.setUniqueCode("U124");

        userRepository.save(user1);
        userRepository.save(user2);

        Team team1 = new Team();
        team1.setTeamName("Development");
        team1.setTeamLead(user1);
        team1.setMembers(new HashSet<>(List.of(user1, user2)));

        teamRepository.save(team1);

        Task task1 = new Task();
        task1.setSummary("Implement Login");
        task1.setDescription("Implement login functionality with Spring Security");
        task1.setStartDate(LocalDate.now());
        task1.setEndDate(LocalDate.now().plusDays(5));
        task1.setStatus("TODO");
        task1.setAssignee(user2);
        task1.setAssigner(user1);
        task1.setTeam(team1);

        taskRepository.save(task1);
    }
}
