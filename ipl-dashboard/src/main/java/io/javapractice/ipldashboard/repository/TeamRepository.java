package io.javapractice.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.javapractice.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
	
	Team findByTeamName(String teamName);

}
