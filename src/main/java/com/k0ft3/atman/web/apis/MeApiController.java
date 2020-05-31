package com.k0ft3.atman.web.apis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.k0ft3.atman.domain.application.BoardService;
import com.k0ft3.atman.domain.application.TeamService;
import com.k0ft3.atman.domain.application.UserService;
import com.k0ft3.atman.domain.common.security.CurrentUser;
import com.k0ft3.atman.domain.common.security.TokenManager;
import com.k0ft3.atman.domain.model.board.Board;
import com.k0ft3.atman.domain.model.team.Team;
import com.k0ft3.atman.domain.model.user.SimpleUser;
import com.k0ft3.atman.domain.model.user.User;
import com.k0ft3.atman.web.results.ApiResult;
import com.k0ft3.atman.web.results.MyDataResult;

@Controller
public class MeApiController {

    private String realTimeServerUrl;
    private TeamService teamService;
    private BoardService boardService;
    private UserService userService;
    private TokenManager tokenManager;

    public MeApiController(@Value("${app.real-time-server-url}") String realTimeServerUrl, TeamService teamService,
            BoardService boardService, UserService userService, TokenManager tokenManager) {
        this.realTimeServerUrl = realTimeServerUrl;
        this.teamService = teamService;
        this.boardService = boardService;
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

    @GetMapping("/api/me")
    public ResponseEntity<ApiResult> getMyData(@CurrentUser SimpleUser currentUser) {
        User user = userService.findById(currentUser.getUserId());
        List<Team> teams = teamService.findTeamsByUserId(currentUser.getUserId());
        List<Board> boards = boardService.findBoardsByMembership(currentUser.getUserId());
        String realTimeToken = tokenManager.jwt(user.getId());
        return MyDataResult.build(user, teams, boards, realTimeServerUrl, realTimeToken);
    }
}