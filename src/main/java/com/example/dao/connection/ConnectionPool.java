package com.example.dao.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class for creating / connecting to pool of connections.
 */
public class ConnectionPool {
    private static final String PROP_FILE_NAME = "hikari.properties";
    private final HikariConfig config  = new HikariConfig();
    private static HikariDataSource dataSource;

    private String jdbcUrl;
//    private String databaseName;
    private String user;
    private String pass;
    private String maxLifetime;
    private String maximumPoolSize;

    /**
     * Creates configuration to the pool and connection.
     * @return connection to hikari.
     */
    public static Connection getHikariConnection() {
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.getResource();
        connectionPool.getConfig();
        try {
            return dataSource.getConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void getResource() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME));
            jdbcUrl = properties.getProperty("jdbcUrl");
//            databaseName = properties.getProperty("databaseName");
            user = properties.getProperty("username");
            pass = properties.getProperty("password");
            maxLifetime = properties.getProperty("maxLifetime");
            maximumPoolSize = properties.getProperty("maximumPoolSize");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void getConfig() {
//        config.setDataSourceClassName(dataSourceClassName);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(user);
        config.setPassword(pass);
        config.setMaxLifetime(Long.parseLong(maxLifetime));
        config.setMaximumPoolSize(Integer.parseInt(maximumPoolSize));
        dataSource = new HikariDataSource(config);
    }
}
