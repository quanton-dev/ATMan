package com.k0ft3.atman.web.payload;

import com.k0ft3.atman.domain.application.commands.CreateTeamCommand;

public class CreateTeamPayload {

    private String name;

    public CreateTeamCommand toCommand() {
        return new CreateTeamCommand(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}