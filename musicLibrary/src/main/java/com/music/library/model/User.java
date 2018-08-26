package com.music.library.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Data
public class User {
    private int id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private LocalDate lastLog;
    private int boughtAlbums;

    public User(int id, String name, String lastName, String login, String password, String email, LocalDate lastLog, int boughtAlbums) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.lastLog = lastLog;
        this.boughtAlbums = boughtAlbums;
    }

    public User(String name, String lastName, String login, String password, String email, LocalDate lastLog, int boughtAlbums) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.lastLog = lastLog;
        this.boughtAlbums = boughtAlbums;
    }

    public void setLastLog() {
        lastLog = LocalDate.now();
    }

    public void increaseBoughtAlbum() {
        boughtAlbums++;
    }

    @Override
    public String toString() {
        return String.format("name:%-10s\nlast name:%-10s\nemail:%-10s\nlast logging:%-10s\nbought albums:%-10s\n"
                , name, lastName, email, lastLog, boughtAlbums);
    }
}
