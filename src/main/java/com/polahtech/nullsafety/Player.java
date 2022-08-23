package com.polahtech.nullsafety;

import org.springframework.lang.NonNull;

public class Player {

    private final @NonNull String name;

    public Player(String name) {
        if (name != null && name.isEmpty()) {
            this.name = null; // SonarLint issue: "@NonNull" values should not be set to null
        } else {
            this.name = name;
        }
    }

    @NonNull
    public String getName() {
        return name;
    }
}
