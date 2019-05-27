package com.friendsurance.impl;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;

/*
    This class demonstrates a very basic implementation of EmailService but it is not intended to send the actual email.

    The actual implementation for this class, will need help of required API or third-party libraries such as JavaMail Api
 */
public class EmailServiceImpl implements EmailService {

    // TODO: We will need to provide implementation for this service and inject it here.
    private MarketingContentService marketingContentService;

    public void sendMail(User recipient, EmailService.MailType mailType) {
        sendMailToRecipient(marketingContentService.generateMarketingContentForUser(
                                mailType, recipient), recipient.getEmail());
    }


    /*
        This method actually send the content to the given recipient
     */
    private void sendMailToRecipient (String content, String email) {
        // Actual implementation using Java Mail api goes here...
    }

}
