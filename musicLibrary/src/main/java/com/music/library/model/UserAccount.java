package com.music.library.model;

import lombok.Getter;

@Getter
public class UserAccount {
    private User user;
    private Wallet wallet;

    public UserAccount(User user, Wallet wallet) {
        this.user = user;
        this.wallet = wallet;
    }


}
