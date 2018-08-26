package com.music.library.dao;

import com.music.library.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class WalletDao extends AbstractDao{

    private static WalletDao dao = null;
    private Connection connection;
    private ResultSet result;
    private PreparedStatement preparedStatement;
    private Statement statement;

    private WalletDao() {
        connection = ConnectDB.getConnection();
    }

    public static WalletDao getDao() {
        if (dao == null) {
            synchronized (WalletDao.class) {
                if (dao == null) {
                    dao = new WalletDao();
                }
            }
        }
        return dao;
    }

    public void addNewWallet(User user) throws SQLException {
        String command = "insert into wallets(balance,user_id) values(1000,?);";
        preparedStatement = connection.prepareStatement(command);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void getHistory() {
        String query = "select history.*, albums.artist, albums.album from wallets join history on wallets.id=history.wallet_id where wallets.user_id in (select id from users where name = ?);";
    }

    public static void main(String[] args) {
//        User user = new User("ania", "andrzejewska", "ania", "123", "ania@gmail.com", LocalDate.now(), 0);
//        WalletDao walletDao = WalletDao.getDao();
//        try {
//            walletDao.addNewWallet(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }


}
