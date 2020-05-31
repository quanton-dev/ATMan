package com.k0ft3.atman.domain.model.team;

import java.util.List;

import com.k0ft3.atman.domain.model.user.UserId;

public interface TeamRepository {

    /**
     * Find the teams that created by a user
     *
     * @param userId the id of the user
     * @return a list of teams or an empty list if none found
     */
    List<Team> findTeamsByUserId(UserId userId);

    /**
     * Find a team by id
     *
     * @param teamId the id of the team
     * @return the team instance or null if not found
     */
    Team findById(TeamId teamId);

    /**
     * Save a team
     *
     * @param team the team to save
     */
    void save(Team team);
}