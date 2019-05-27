package com.friendsurance.impl;

import com.friendsurance.processing.OutputItem;
import com.friendsurance.mail.EmailService;
import com.friendsurance.processing.ItemWriter;

/*
    Sample implementation of ItemWriter interface for EmailService to send emails

    Ideally, we shall be using some sort of Dependency Injection mechanism to auto inject

    implementation of EmailService into this class

 */
public class EmailItemWriter implements ItemWriter<OutputItem> {

    // TODO: Later, We need to inject an implementation for EmailService using Dependency Injection frameworks
    private EmailService emailService = new EmailServiceImpl();

    public void write(OutputItem item) {
        emailService.sendMail(item.getUser(), item.getMailType());
    }
}
