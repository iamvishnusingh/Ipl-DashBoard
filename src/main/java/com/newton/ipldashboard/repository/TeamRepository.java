package com.newton.ipldashboard.repository;

import com.newton.ipldashboard.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
Team findByTeamName(String teamName);
}
