package io.javapractice.ipldashboard.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.javapractice.ipldashboard.model.Match;
import io.javapractice.ipldashboard.model.Team;
import io.javapractice.ipldashboard.repository.MatchRepository;
import io.javapractice.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController { 
	
	private TeamRepository teamRepository;
	private MatchRepository matchRepository;
	
	@Autowired
	public TeamController(TeamRepository teamRepository,  MatchRepository matchRepository) {
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}
	
	@GetMapping("/team")
	public Iterable<Team> getAllTeams() {
		return this.teamRepository.findAll();
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = this.teamRepository.findByTeamName(teamName);
		team.setMatches(this.matchRepository.findLatestMatchesbyTeam(teamName, 4));
		return team;
	}
	
	@GetMapping("/team/{teamName}/matches")
	public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
		LocalDate startDate = LocalDate.of(year, 1, 1);
		LocalDate enDate = LocalDate.of(year+1, 1, 1);
		return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, enDate);
	}
	
	
}
