package com.music.library.dao;

import com.music.library.model.Album;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class AlbumDao extends AbstractDao{
    private static AlbumDao dao = null;
    private Connection connection;
    private ResultSet result;
    private PreparedStatement preparedStatement;

    private AlbumDao() {
        this.connection = ConnectDB.getConnection();
    }

    public static AlbumDao getDao() {
        if (dao == null) {
            synchronized (AlbumDao.class) {
                if (dao == null) {
                    dao = new AlbumDao();
                }
            }
        }
        return dao;
    }

    private void closeAll(Statement preparedStatement) throws SQLException {
        result.close();
        preparedStatement.close();
    }

    public void getAllRecords() throws SQLException {
        String query = "select id, artist, album, year, duration, price from albums;";
        Statement statement = connection.createStatement();
        result = statement.executeQuery(query);
        displayAll(result);
        statement.close();
        closeAll(statement);
    }

    public void getAlbumBy(String value) throws SQLException {
        String query = "select id, artist, album, year, duration, price from albums where artist=? or album=? or year=?;";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,value);
        preparedStatement.setString(2,value);
        preparedStatement.setString(3,value);
        result = preparedStatement.executeQuery();
        displayAll(result);
        closeAll(preparedStatement);
    }

    private Album createAlbum(ResultSet result) throws SQLException {
        String artist = result.getString(1);
        String album = result.getString(2);
        String year = result.getString(3);
        String spotify = result.getString(4);
        String description = result.getString(5);
        String wiki = result.getString(6);
        String duration = result.getString(7);
        int min = result.getInt(8);
        int sec = result.getInt(9);

        return new Album(artist, album, year, spotify, description, wiki, duration, min, sec);
    }

    public static void main(String[] args) {
        AlbumDao album = getDao();
        try {
            album.getAllRecords();
//            album.getAlbumBy("Metallica");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
