package com.example.graphql;

import java.util.ArrayList;
import java.util.List;

public class Droid implements Character {
    private Long id;
    private String name;
    private List<String> appearsIn;
    private String primaryFunction;
    private final List<Character> friends = new ArrayList<>();

    public Droid(Long id, String name) {
        this(id, name, List.of("NEWHOPE", "EMPIRE", "JEDI"), null);
    }

    public Droid(Long id, String name, List<String> appearsIn, String primaryFunction) {
        this.id = id;
        this.name = name;
        this.appearsIn = new ArrayList<>(appearsIn);
        this.primaryFunction = primaryFunction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAppearsIn() {
        return appearsIn;
    }

    public void setAppearsIn(List<String> appearsIn) {
        this.appearsIn = new ArrayList<>(appearsIn);
    }

    public String getPrimaryFunction() {
        return primaryFunction;
    }

    public void setPrimaryFunction(String primaryFunction) {
        this.primaryFunction = primaryFunction;
    }

    @Override
    public List<Character> getFriends() {
        return friends;
    }
}
