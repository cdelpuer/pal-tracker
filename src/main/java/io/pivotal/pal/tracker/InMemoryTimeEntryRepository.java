package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Long x = 1L;
    private Map<Long, TimeEntry> timeEntries = new HashMap<Long, TimeEntry>();

    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(x);
        timeEntries.put(x, timeEntry);
        x++;
        return timeEntry;
    }

    public TimeEntry find(long id) {

        return timeEntries.get(id);
    }

    public List<TimeEntry> list() {
        return timeEntries.values().stream().collect(Collectors.toList());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (timeEntries.get(id) == null)
            return null;

        timeEntry.setId(id);
        timeEntries.put(id, timeEntry);

        return timeEntry;
    }

    public void delete(long id) {
        timeEntries.remove(id);
    }
}
