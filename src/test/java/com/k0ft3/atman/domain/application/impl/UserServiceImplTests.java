package com.k0ft3.atman.domain.application.impl;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.k0ft3.atman.domain.application.commands.RegistrationCommand;
import com.k0ft3.atman.domain.common.event.DomainEventPublisher;
import com.k0ft3.atman.domain.common.mail.MailManager;
import com.k0ft3.atman.domain.common.mail.MessageVariable;
import com.k0ft3.atman.domain.model.user.EmailAddressExistsException;
import com.k0ft3.atman.domain.model.user.RegistrationException;
import com.k0ft3.atman.domain.model.user.RegistrationManagement;
import com.k0ft3.atman.domain.model.user.User;
import com.k0ft3.atman.domain.model.user.UsernameExistsException;
import com.k0ft3.atman.domain.model.user.events.UserRegisteredEvent;

public class UserServiceImplTests {

    private RegistrationManagement registrationManagementMock;
    private DomainEventPublisher domainEventPublisherMock;
    private MailManager mailManagerMock;
    private UserServiceImpl instance;

    @Before
    public void setUp() {
        registrationManagementMock = mock(RegistrationManagement.class);
        domainEventPublisherMock = mock(DomainEventPublisher.class);
        mailManagerMock = mock(MailManager.class);
        instance = new UserServiceImpl(registrationManagementMock, domainEventPublisherMock, mailManagerMock);
    }

    @Test(expected = IllegalArgumentException.class)
    public void register_nullCommand_shouldFail() throws RegistrationException {
        instance.register(null);
    }

    @Test(expected = RegistrationException.class)
    public void register_existingUsername_shouldFail() throws RegistrationException {
        String username = "existing";
        String emailAddress = "sunny@example.com";
        String password = "MyPassword!";
        doThrow(UsernameExistsException.class).when(registrationManagementMock).register(username, emailAddress,
                password);

        RegistrationCommand command = new RegistrationCommand(username, emailAddress, password);
        instance.register(command);
    }

    @Test(expected = RegistrationException.class)
    public void register_existingEmailAddress_shouldFail() throws RegistrationException {
        String username = "sunny";
        String emailAddress = "existing@example.com";
        String password = "MyPassword!";
        doThrow(EmailAddressExistsException.class).when(registrationManagementMock).register(username, emailAddress,
                password);

        RegistrationCommand command = new RegistrationCommand(username, emailAddress, password);
        instance.register(command);
    }

    @Test
    public void register_validCommand_shouldSucceed() throws RegistrationException {
        String username = "sunny";
        String emailAddress = "sunny@example.com";
        String password = "MyPassword!";
        User newUser = User.create(username, emailAddress, password);
        when(registrationManagementMock.register(username, emailAddress, password)).thenReturn(newUser);
        RegistrationCommand command = new RegistrationCommand(username, emailAddress, password);

        instance.register(command);

        verify(mailManagerMock).send(emailAddress, "Welcome to ATMan", "welcome.ftl",
                MessageVariable.from("user", newUser));
        verify(domainEventPublisherMock).publish(new UserRegisteredEvent(newUser));
    }
}