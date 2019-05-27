package com.friendsurance.service;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;

/*
    This class provides marketing contents to be sent for users based on their status. To that we will need to have

    User information and perhaps reference to some Content Repository services.
 */
public class MarketingContentServiceImpl implements MarketingContentService {

    /*
        This method generate customized Email content based on MailType and user in HTML or Text .
     */
    public String generateMarketingContentForUser(EmailService.MailType mailType, User recipient) {
        switch (mailType) {
            case MAIL_TYPE_1:
                return "Hey "+ recipient.getName()+", do you remember us? Give us a try and be social with your insurances!";

            case MAIL_TYPE_2:
                return "Email Template for Type 2";

            case MAIL_TYPE_3:
                return "Email Template for Type 3";

            case MAIL_TYPE_4:

                return "Email Template for Type 4";

            case MAIL_TYPE_5:
                return "Email Template for Type 5";
        }

        return "Default template";
    }
}
