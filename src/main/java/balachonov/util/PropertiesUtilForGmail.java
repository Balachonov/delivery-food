package balachonov.util;

import java.util.Properties;

import static balachonov.util.Constants.*;

public class PropertiesUtilForGmail {
    private static Properties propertiesForGmail;

    public static Properties getPropertiesForGmail() {
        if (propertiesForGmail == null) {
            propertiesForGmail = new Properties();
        }
        return propertiesForGmail;
    }

    static {
        propertiesForGmail.put("mail.smtp.user", COMPANY_GMAIL);
        propertiesForGmail.put("mail.smtp.password", PASSWORD_FOR_GMAIL);
        propertiesForGmail.put("mail.smtp.port", PORT);
        propertiesForGmail.put("mail.smtp.auth", TRUE);
        propertiesForGmail.put("mail.smtp.host", HOST);
        propertiesForGmail.put("mail.smtp.starttls.enable", TRUE);
    }

    private PropertiesUtilForGmail() {
    }
}
