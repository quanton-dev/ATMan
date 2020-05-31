package com.k0ft3.atman.infrastructure.mail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.k0ft3.atman.domain.common.mail.SimpleMessage;

public class AsyncMailerTests {

    private JavaMailSender mailSenderMock;
    private AsyncMailer instance;

    @Before
    public void setUp() {
        mailSenderMock = mock(JavaMailSender.class);
        instance = new AsyncMailer(mailSenderMock);
    }

    @Test(expected = IllegalArgumentException.class)
    public void send_nullMessage_shouldFail() {
        instance.send(null);
    }

    @Test
    public void send_validMessage_shouldSucceed() {
        String from = "system@atman.com";
        String to = "console.output@atman.com";
        String subject = "A test message";
        String body = "Username: test, Email Address: test@atman.com";

        SimpleMessage message = new SimpleMessage(to, subject, body, from);
        instance.send(message);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("Username: test, Email Address: test@atman.com");
        verify(mailSenderMock).send(simpleMailMessage);
    }

}