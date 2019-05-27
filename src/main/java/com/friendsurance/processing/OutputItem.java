package com.friendsurance.processing;


import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;

/*
    A sample output item which holds the contents which should be sent to user by user.
 */
public class OutputItem {

    private User recipient;

    private EmailService.MailType mailType;

    public OutputItem(User emailRecipient, EmailService.MailType mailType) {
        this.recipient = emailRecipient;
        this.mailType = mailType;
    }

    public User getUser() {
        return recipient;
    }

    public EmailService.MailType getMailType() {
        return mailType;
    }

}
