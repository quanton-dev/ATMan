package com.k0ft3.atman.domain.common.security;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptorDelegator implements PasswordEncryptor {

    @Override
    public String encrypt(String rawPassword) {
        return rawPassword;
    }
}