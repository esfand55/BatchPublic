package com.friendsurance.processing;

import com.friendsurance.backend.User;

/*
    Sample input item which could contain many information including the user info
 */
public class InputItem {
    private User user;

    public InputItem(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
