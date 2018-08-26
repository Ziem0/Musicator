package com.music.library.dao;

import com.music.library.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class UserDao extends AbstractDao{
    private static UserDao dao = null;
    private Connection connection;
    private ResultSet result;
    private PreparedStatement preparedStatement;
    private Statement statement;

    private UserDao() {
        this.connection = ConnectDB.getConnection();
    }

    public static UserDao getDao() {
        if (dao == null) {
            synchronized (UserDao.class) {
                if (dao == null) {
                    dao = new UserDao();
                }
            }
        }
        return dao;
    }

    private User createAlbum(ResultSet result) throws SQLException {
        String name = result.getString(1);
        String lastName = result.getString(2);
        String login = result.getString(3);
        String password = result.getString(4);
        String email = result.getString(5);
        LocalDate lastLog = LocalDate.parse(result.getString(6));
        int boughtAlbums = result.getInt(7);
        result.close();
        preparedStatement.close();
        return new User(name, lastName,login,password,email,lastLog,boughtAlbums);
    }

    public User getUser(String login, String password) throws SQLException {
        String query = "select * from users where login=? and password=?;";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        result = preparedStatement.executeQuery();
        return createAlbum(result);
    }

    public void addNewUser(User user) throws SQLException {
        String name = user.getName();
        String lastName = user.getLastName();
        String login = user.getLogin();
        String password = user.getPassword();
        String email = user.getEmail();
        String lastLog =    user.getLastLog().format(DateTimeFormatter.ISO_LOCAL_DATE);
        int albumsAmount = user.getBoughtAlbums();

        String command = "insert into users(name,lastName,login,password,email,logging,albums) values(?,?,?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(command);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,lastName);
        preparedStatement.setString(3,login);
        preparedStatement.setString(4,password);
        preparedStatement.setString(5,email);
        preparedStatement.setString(6, lastLog);
        preparedStatement.setInt(7, albumsAmount);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void main(String[] args) {
        UserDao userdao = UserDao.getDao();
        User user = new User("ania", "andrzejewska", "ania", "123", "ania@gmail.com", LocalDate.now(), 0);
        try {
            userdao.addNewUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
