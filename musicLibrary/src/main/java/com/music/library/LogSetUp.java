package com.music.library;


import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.jdbc.JDBCAppender;

public class LogSetUp {

    private static LogSetUp logSetUp = null;
    private static final String LOGGING_DB_PATH = "jdbc:sqlite:musicLibrary/src/main/resources/logDB.db";

    private LogSetUp() {
        Appender app = new JDBCAppender();
        ((JDBCAppender) app).setBufferSize(1);
        ((JDBCAppender) app).setUser("user");
        ((JDBCAppender) app).setPassword("123");
        ((JDBCAppender) app).setDriver("org.sqlite.JDBC");
        ((JDBCAppender) app).setURL(LOGGING_DB_PATH);
        ((JDBCAppender) app).setSql("insert into log(level, type, message, date) values('%p', '%c', '%m', '%d');");
        BasicConfigurator.configure(app);
    }

    public static LogSetUp getLogSetUp() {
        if (logSetUp == null) {
            synchronized (LogSetUp.class) {
                if (logSetUp == null) {
                    logSetUp = new LogSetUp();
                }
            }
        }
        return logSetUp;
    }

}
