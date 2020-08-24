package com.example.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Lesson {
    /**
     * During a lesson, represented by the 'Lesson' class, a teacher teaches a subject to a group of students.
     * During solving, OptaPlanner changes the 'timeslot' and 'room' fields of the 'Lesson' class,
     * to assign each lesson to a time slot and a room. Because Optaplanner changes these fields,
     * Lesson is a 'Planning Entity'.
     *
     * The 'Lesson' class has an @PlanningEntity annotation, so Optaplanner knows that this class changes during
     * solving because it contains one or more planning variables.
     *
     * The 'timeslot' field has an @PlanningVariable annotation, so Optaplanner knows that it can change its value.
     * In order to find potential 'timeslot' instances to assign to this field, Optaplanner uses the
     * 'valueRangeProviderRefs' property to connect to a value range provider that provides a List<Timeslot> to pick from.
     *
     * The 'room' field also has an @PlanningVariable annotation, for the same reasons.
     */

    private Long id;

    private String subject;
    private String teacher;
    private String studentGroup;

    @PlanningVariable(valueRangeProviderRefs = "timeslotRange")
    private Timeslot timeslot;

    @PlanningVariable(valueRangeProviderRefs = "roomRange")
    private Room room;

    private Lesson() {
    }

    public Lesson(Long id, String subject, String teacher, String studentGroup) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        this.studentGroup = studentGroup;
    }

    @Override
    public String toString() {
        return subject + "(" + id + ")";
    }

    // ********************************
    // Getters and setters
    // ********************************

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}