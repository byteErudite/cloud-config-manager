package com.configservice.common.model;

import java.sql.Timestamp;
import java.util.StringJoiner;

public class Resource {
    private String name;
    private Timestamp createdAt;
    private String identifier;

    public Resource(String name, Timestamp createdAt, String identifier) {
        this.name = name;
        this.createdAt = createdAt;
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Resource.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("createdAt=" + createdAt)
                .add("identifier='" + identifier + "'")
                .toString();
    }
}
