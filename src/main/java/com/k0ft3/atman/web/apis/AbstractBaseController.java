package com.k0ft3.atman.web.apis;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

import com.k0ft3.atman.domain.application.commands.AnonymousCommand;
import com.k0ft3.atman.domain.application.commands.UserCommand;
import com.k0ft3.atman.domain.model.user.SimpleUser;
import com.k0ft3.atman.utils.RequestUtils;

public abstract class AbstractBaseController {

    void addTriggeredBy(UserCommand command, HttpServletRequest request) {
        Assert.notNull(request.getUserPrincipal(), "User principal must be present in the request");
        UsernamePasswordAuthenticationToken userPrincipal = (UsernamePasswordAuthenticationToken) request
                .getUserPrincipal();
        SimpleUser currentUser = (SimpleUser) userPrincipal.getPrincipal();
        command.triggeredBy(currentUser.getUserId(), RequestUtils.getIpAddress(request));
    }

    void addTriggeredBy(AnonymousCommand command, HttpServletRequest request) {
        command.triggeredBy(RequestUtils.getIpAddress(request));
    }
}