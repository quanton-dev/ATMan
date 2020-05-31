package com.k0ft3.atman.web.apis;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

import com.k0ft3.atman.domain.application.TeamService;
import com.k0ft3.atman.domain.application.commands.CreateTeamCommand;
import com.k0ft3.atman.domain.model.team.Team;
import com.k0ft3.atman.web.payload.CreateTeamPayload;
import com.k0ft3.atman.web.results.ApiResult;
import com.k0ft3.atman.web.results.CreateTeamResult;

@Controller
public class TeamApiController extends AbstractBaseController {

    private TeamService teamService;

    public TeamApiController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/api/teams")
    public ResponseEntity<ApiResult> createTeam(@RequestBody CreateTeamPayload payload, HttpServletRequest request) {
        CreateTeamCommand command = payload.toCommand();
        addTriggeredBy(command, request);

        Team team = teamService.createTeam(command);
        return CreateTeamResult.build(team);
    }
}