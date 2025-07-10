package com.league.teamservice.controller;

import com.league.teamservice.model.Team;
import com.league.teamservice.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        System.out.println("EVENT: team.created -> " + team.getName());
        return teamRepository.save(team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
