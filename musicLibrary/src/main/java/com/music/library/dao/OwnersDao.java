package com.music.library.dao;

import com.music.library.model.Album;
import com.music.library.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class OwnersDao extends AbstractDao {
    private static OwnersDao dao = null;
    private Connection connection;
    private ResultSet result;
    private PreparedStatement preparedStatement;
    private Statement statement;

    private OwnersDao() {
        this.connection = ConnectDB.getConnection();
    }

    public static OwnersDao getDao() {

        if (dao == null) {
            synchronized (OwnersDao.class) {
                if (dao == null) {
                    dao = new OwnersDao();
                }
            }
        }
        return dao;
    }

    public void addNewRecord(User user, Album album) throws SQLException {   //check if available
        String command = "insert into owners values(?,?);";
        preparedStatement = connection.prepareStatement(command);
        preparedStatement.setInt(1,user.getId());
        preparedStatement.setInt(2,album.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }



}
