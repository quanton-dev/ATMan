package com.k0ft3.atman.domain.application.impl;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.k0ft3.atman.domain.application.TeamService;
import com.k0ft3.atman.domain.application.commands.CreateTeamCommand;
import com.k0ft3.atman.domain.common.event.DomainEventPublisher;
import com.k0ft3.atman.domain.model.team.Team;
import com.k0ft3.atman.domain.model.team.TeamId;
import com.k0ft3.atman.domain.model.team.TeamRepository;
import com.k0ft3.atman.domain.model.team.events.TeamCreatedEvent;
import com.k0ft3.atman.domain.model.user.UserId;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;
    private DomainEventPublisher domainEventPublisher;

    public TeamServiceImpl(TeamRepository teamRepository, DomainEventPublisher domainEventPublisher) {
        this.teamRepository = teamRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public List<Team> findTeamsByUserId(UserId userId) {
        return teamRepository.findTeamsByUserId(userId);
    }

    @Override
    public Team findById(TeamId teamId) {
        return teamRepository.findById(teamId);
    }

    @Override
    public Team createTeam(CreateTeamCommand command) {
        Team team = Team.create(command.getName(), command.getUserId());
        teamRepository.save(team);
        domainEventPublisher.publish(new TeamCreatedEvent(team, command));
        return team;
    }
}