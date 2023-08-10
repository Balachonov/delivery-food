package balachonov.services;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import static balachonov.util.Constants.*;
@Slf4j
public class PasswordGenerationAndCheckImpl implements PasswordGenerationAndCheck {
    private static PasswordGenerationAndCheckImpl passwordGenerationAndCheck;

    public static PasswordGenerationAndCheckImpl getPasswordGenerationAndCheck() {
        if (passwordGenerationAndCheck == null) {
            passwordGenerationAndCheck = new PasswordGenerationAndCheckImpl();
        }
        return passwordGenerationAndCheck;
    }

    @Override
    public boolean checkPassword(String inputPassword, String password, String salt) {
        String hashInputPassword = getHashPassword(inputPassword, salt);
        byte[] bytesHashInputPassword = hashInputPassword.getBytes(StandardCharsets.UTF_16);
        byte[] bytesPassword = password.getBytes(StandardCharsets.UTF_16);
        log.info(LOG_PASS_CHECKED);
        return Arrays.equals(bytesPassword, bytesHashInputPassword);
    }

    @Override
    public String getHashPassword(String password, String salt) {
        int keyLength = 160;
        int iteration = 20000;
        try {
            byte[] bytesSalt = salt.getBytes(StandardCharsets.UTF_16);
            KeySpec spec = new PBEKeySpec(password.toCharArray(), bytesSalt, iteration, keyLength);
            SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM_PASS);
            byte[] bytes = f.generateSecret(spec).getEncoded();
            log.info(LOG_PASS_GENERATED);
            return new String(bytes, CODE);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | UnsupportedEncodingException ex) {
            log.error(LOG_ERR_PASS_GENERATED, ex);
        }
        return DEFAULT;
    }

    @Override
    public String generationSalt() {
        try {
            SecureRandom random = SecureRandom.getInstance(ALGORITHM_SALT);
            byte[] salt = new byte[8];
            random.nextBytes(salt);
            log.info(LOG_SALT_GENERATED);
            return new String(salt, CODE);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            log.error(LOG_ERR_SALT_GENERATED, ex);
        }
        return DEFAULT;
    }

    private PasswordGenerationAndCheckImpl() {
    }
}
