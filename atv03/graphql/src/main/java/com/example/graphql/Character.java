package com.example.graphql;

import java.util.List;

public interface Character {
    Long getId();

    String getName();

    List<String> getAppearsIn();

    List<Character> getFriends();
}