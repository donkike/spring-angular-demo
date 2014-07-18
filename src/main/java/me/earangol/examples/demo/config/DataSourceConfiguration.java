package me.earangol.examples.demo.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created with IntelliJ IDEA.
 */
@Configuration
public class DataSourceConfiguration {

    /**
     * Returns the DataSource needed to connect with the PostgreSQL database
     * @return
     * @throws IOException When there's a problem reading the database.properties configuration file
     */
    @Bean
    public DataSource dataSource() throws IOException {
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/me/earangol/examples/demo/db/database.properties"));

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerName(prop.getProperty("db.serverName"));
        ds.setPortNumber(Integer.parseInt(prop.getProperty("db.portNumber")));
        ds.setDatabaseName(prop.getProperty("db.databaseName"));
        ds.setUser(prop.getProperty("db.user"));
        ds.setPassword(prop.getProperty("db.password"));
        return ds;
    }

    /**
     * JdbcOperations used to send statements and receive responses from the database
     * @return
     * @throws IOException
     */
    @Bean
    public JdbcOperations db() throws IOException {
        return new JdbcTemplate(dataSource());
    }
}
