package com.simon.core.mobile;

public enum Direction {
    UP("up"),
    DOWN("down"),
    LEFT("left"),
    RIGHT("right");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String direction() {
        return this.direction;
    }
}
