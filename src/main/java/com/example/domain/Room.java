package com.example.domain;

public class Room {
    /**
     * Room Class represents a location where lessons are taught.
     * Room instances do not change during solving, so Room is also a 'Problem Fact'.
     */

    private String name;

    private Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    // ********************************
    // Getters and setters
    // ********************************

    public String getName() {
        return name;
    }

}