package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long projectId, long userId, LocalDate parse, int i) {
        
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int i) {
        
    }

    public TimeEntry() {

    }

    public Long getId() {
        return this.id;
    }
}
