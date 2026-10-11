package com.example.graphql;

import java.util.ArrayList;
import java.util.List;

public class Human implements Character {
    private long id;
    private String name;
    private Float height;
    private List<String> appearsIn;
    private final List<Character> friends = new ArrayList<>();

    public Human(long id, String name, float height) {
        this(id, name, height, List.of());
    }

    public Human(long id, String name, Float height, List<String> appearsIn) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.appearsIn = new ArrayList<>(appearsIn);
    }

    public Long getId() {
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

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    @Override
    public List<String> getAppearsIn() {
        return appearsIn;
    }

    public void setAppearsIn(List<String> appearsIn) {
        this.appearsIn = new ArrayList<>(appearsIn);
    }

    @Override
    public List<Character> getFriends() {
        return friends;
    }
}

