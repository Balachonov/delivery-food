package balachonov.services.impl;

import balachonov.services.PasswordGenerationAndCheck;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordGenerationAndCheckImpl implements PasswordGenerationAndCheck {

    private final Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    @Override
    public boolean checkPassword(String inputPassword, String password) {
        return encoder.matches(inputPassword, password);
    }

    @Override
    public String getHashPassword(String password) {
        return encoder.encode(password);
    }
}