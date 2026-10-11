package com.example.graphql;

public class Starship {
    private long id;
    private String name;
    private Float length;

    public Starship(long id, String name, Float length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }
}

