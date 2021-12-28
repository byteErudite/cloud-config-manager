package com.configservice.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.StringJoiner;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DbProperties {
    private String databaseName;
    private String url;
    private String username;
    private String password;
    @JsonProperty("driver-class-name")
    private String driverClassName;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DbProperties.class.getSimpleName() + "[", "]")
                .add("databaseName='" + databaseName + "'")
                .add("url='" + url + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("deriverClassName='" + driverClassName + "'")
                .toString();
    }
}
