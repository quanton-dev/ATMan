package com.k0ft3.atman.web.payload;

import com.k0ft3.atman.domain.application.commands.CreateBoardCommand;
import com.k0ft3.atman.domain.model.team.TeamId;

public class CreateBoardPayload {

    private String name;
    private String description;
    private long teamId;

    public CreateBoardCommand toCommand() {
        return new CreateBoardCommand(name, description, new TeamId(teamId));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

}