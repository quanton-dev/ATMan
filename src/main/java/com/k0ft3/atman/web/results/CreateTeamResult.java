package com.k0ft3.atman.web.results;

import com.k0ft3.atman.domain.model.team.Team;

import org.springframework.http.ResponseEntity;

public class CreateTeamResult {

    public static ResponseEntity<ApiResult> build(Team team) {
        ApiResult apiResult = ApiResult.blank().add("id", team.getId().value()).add("name", team.getName());
        return Result.ok(apiResult);
    }
}