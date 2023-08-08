package balachonov.services;

import balachonov.dto.PersonDto;
import balachonov.util.PropertiesUtilForGmail;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

import static balachonov.util.Constants.*;

public class EmailSender {
    public void sendMessageFromGmail(PersonDto personDto){
        Session session = Session.getDefaultInstance(PropertiesUtilForGmail.getPropertiesForGmail());
        try {
            MimeMessage message = getMimeMessage(personDto, session);
            getTransportForSendMail(session, message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private MimeMessage getMimeMessage(PersonDto personDto, Session session) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(COMPANY_GMAIL));
        message.setSubject(SUBJECT_MAIL);
        message.setText(prepareMessage(personDto));
        return message;
    }

    private static void getTransportForSendMail(Session session, MimeMessage message) throws MessagingException {
        Transport transport = session.getTransport(TRANSPORT_PROTOCOL);
        transport.connect(HOST, COMPANY_GMAIL, PASSWORD_FOR_GMAIL);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    private String prepareMessage(PersonDto personDto){
        return String.format(MESSAGE_FOR_CLIENT, personDto.getFirstName());
    }

}
