package com.k0ft3.atman.domain.common.security;

public interface PasswordEncryptor {

    /**
     * Encrypt a raw password
     */
    String encrypt(String rawPassword);
}