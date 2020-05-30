package com.k0ft3.atman.domain.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

import com.k0ft3.atman.domain.application.UserService;
import com.k0ft3.atman.domain.application.commands.RegistrationCommand;
import com.k0ft3.atman.domain.common.event.DomainEventPublisher;
import com.k0ft3.atman.domain.common.mail.MailManager;
import com.k0ft3.atman.domain.common.mail.MessageVariable;
import com.k0ft3.atman.domain.model.user.RegistrationException;
import com.k0ft3.atman.domain.model.user.RegistrationManagement;
import com.k0ft3.atman.domain.model.user.User;
import com.k0ft3.atman.domain.model.user.events.UserRegisteredEvent;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private RegistrationManagement registrationManagement;
    private DomainEventPublisher domainEventPublisher;
    private MailManager mailManager;

    public UserServiceImpl(RegistrationManagement registrationManagement, DomainEventPublisher domainEventPublisher,
            MailManager mailManager) {
        this.registrationManagement = registrationManagement;
        this.domainEventPublisher = domainEventPublisher;
        this.mailManager = mailManager;
    }

    @Override
    public void register(RegistrationCommand command) throws RegistrationException {
        Assert.notNull(command, "Parameter `command` must not be null");
        User newUser = registrationManagement.register(command.getUsername(), command.getEmailAddress(),
                command.getPassword());

        sendWelcomeMessage(newUser);
        domainEventPublisher.publish(new UserRegisteredEvent(newUser));
    }

    private void sendWelcomeMessage(User user) {
        mailManager.send(user.getEmailAddress(), "Welcome to ATMan", "welcome.ftl", MessageVariable.from("user", user));
    }
}