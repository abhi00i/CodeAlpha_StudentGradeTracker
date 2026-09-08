package com.codealpha.gradetracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single student with a name and a list of marks.
 * Provides methods to add marks and compute basic statistics.
 */
public class Student {

    private String name;
    private List<Integer> marks;

    public Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    /**
     * Adds a mark to this student's record.
     * Caller is expected to validate the range (0-100) before calling this,
     * but we double-check here as a safety net.
     */
    public void addMark(int mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100.");
        }
        marks.add(mark);
    }

    /**
     * Returns the average of all marks, or 0.0 if no marks exist.
     */
    public double getAverage() {
        if (marks.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.size();
    }

    /**
     * Returns the highest mark, or 0 if no marks exist.
     */
    public int getHighest() {
        if (marks.isEmpty()) {
            return 0;
        }
        int highest = marks.get(0);
        for (int m : marks) {
            if (m > highest) {
                highest = m;
            }
        }
        return highest;
    }

    /**
     * Returns the lowest mark, or 0 if no marks exist.
     */
    public int getLowest() {
        if (marks.isEmpty()) {
            return 0;
        }
        int lowest = marks.get(0);
        for (int m : marks) {
            if (m < lowest) {
                lowest = m;
            }
        }
        return lowest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Marks: ").append(marks).append("\n");
        sb.append(String.format("Average: %.2f | Highest: %d | Lowest: %d",
                getAverage(), getHighest(), getLowest()));
        return sb.toString();
    }
}
