package com.friendsurance.backend;

import com.friendsurance.mail.EmailRecipient;

/**
 * Encapsulates the information about user's situation.
 */
public class User implements EmailRecipient {

    /*
        TODO: I only added this attribute only for demonstration purpose of customized content generation otherwise,

         it is not mandatory 
     */
    private String name;

    private String  email;
    private boolean hasContract;
    private int     friendsNumber;
    private int     sentInvitationsNumber;

    public User(String email, boolean hasContract, int friendsNumber, int sentInvitationsNumber) {
        this.email = email;
        this.hasContract = hasContract;
        this.friendsNumber = friendsNumber;
        this.sentInvitationsNumber = sentInvitationsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public boolean hasContract() {
        return hasContract;
    }

    public int getFriendsNumber() {
        return friendsNumber;
    }

    public int getSentInvitationsNumber() {
        return sentInvitationsNumber;
    }

    @Override
    public String toString() {
        return "User{" +
               "email='" + email + '\'' +
               ", hasContract=" + hasContract +
               ", friendsNumber=" + friendsNumber +
               ", sentInvitationsNumber=" + sentInvitationsNumber +
               '}';
    }

}
