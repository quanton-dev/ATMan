package com.k0ft3.atman.domain.application;

import java.util.List;

public interface TeamService {

    /**
     * Find the teams that created by a user
     *
     * @param userId the id of the user
     * @return a list of teams or an empty list if none found
     */
    List<Team> findTeamsByUserId(UserId userId);

    /**
     * Find a team by its id
     *
     * @param teamId the id of the team
     * @return a team instance or null if not found
     */
    Team findById(TeamId teamId);

    /**
     * Create a new team
     *
     * @param command the command instance
     * @return the newly created team
     */
    Team createTeam(CreateTeamCommand command);

}