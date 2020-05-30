package com.k0ft3.atman.domain.common.mail;

public interface MailManager {

    void send(String emailAddress, String subject, String template, MessageVariable... variables);
}