package com.example.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class TimeTable {
    /**
     * A 'timeTable' wraps all 'timeslot', 'Room', and 'Lesson' instances of a single dataset. Furthermore, because it
     * contains all lessons, each with specific planning variable state, it is a 'Planning Solution' amd it has a score.
     *
     * The 'timeTable' class has an @PlanningSolution annotation, so OptaPlanner knows that this class contains all
     * of the input and output data.
     *
     * Specifically, this class is the input of the problem:
     * - A timeslotList field with all timeslots:
     * This is a list of problem facts, because they do not change during solving.
     * - A roomList field with all rooms:
     * This is a list of problem facts, because they do not change during solving.
     * - A lessonList field with all lessons:
     * This is a list of planning entities, because they change during solving.
     * Of each Lesson:
     *  - The values of the timeslot and room fields are typically still 'null', so unassigned. They are planning variables.
     *  - The other fields, such as subject, teacher and studentGroup, are filled in. These fields are
     *    problem properties.
     *
     * This class is also the output of the solution:
     * - A lessonList field for which each Lesson instance has non-null timeslot and room fields after solving.
     * - A score fields that rpresents the quality of the output solution.
     */

    @ValueRangeProvider(id = "timeslotRange")
    @ProblemFactCollectionProperty
    private List<Timeslot> timeslotList;

    @ValueRangeProvider(id = "roomRange")
    @ProblemFactCollectionProperty
    private List<Room> roomList;

    @PlanningEntityCollectionProperty
    private List<Lesson> lessonList;

    @PlanningScore
    private HardSoftScore score;

    private TimeTable() {
    }

    public TimeTable(List<Timeslot> timeslotList, List<Room> roomList,
                     List<Lesson> lessonList) {
        this.timeslotList = timeslotList;
        this.roomList = roomList;
        this.lessonList = lessonList;
    }

    // ********************************
    // Getters and setters
    // ********************************

    public List<Timeslot> getTimeslotList() {
        return timeslotList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public HardSoftScore getScore() {
        return score;
    }

}