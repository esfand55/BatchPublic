package com.friendsurance.impl;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;

public interface MarketingContentService {

    String generateMarketingContentForUser (EmailService.MailType mailType, User recipient);
}
