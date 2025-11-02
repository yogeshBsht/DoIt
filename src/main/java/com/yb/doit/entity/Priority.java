package com.yb.doit.entity;

public enum Priority {
    HIGH(0),
    MEDIUM(1),
    LOW(2);

    private final int level;

    Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

