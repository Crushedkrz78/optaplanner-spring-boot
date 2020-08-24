package com.example.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {
    /**
     * Timeslot class represents a time interval when lessons are taught.
     * Timeslot is called a 'Problem Fact' because it's not suffering changes during solving, and do not
     * require any Optaplanner specific annotations.
     */

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    private Timeslot() {
    }

    public Timeslot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return dayOfWeek + " " + startTime.toString();
    }

    // ********************************
    // Getters and setters
    // ********************************

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

}