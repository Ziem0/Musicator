package com.music.library.model;

import com.music.library.dao.WalletDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wallet {

    private int balance;
    private WalletDao history;

    public Wallet(int balance) {
        this.balance = balance;
//        this.history = WalletDao.
    }
}
