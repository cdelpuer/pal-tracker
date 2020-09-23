package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping ("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry created = this.timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    @GetMapping ("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long timeEntryId) {
        TimeEntry timeEntry = this.timeEntryRepository.find(timeEntryId);
        if (timeEntry == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(timeEntry, HttpStatus.OK);
    }

    @PutMapping ("/time-entries/{timeEntryId}")
    public ResponseEntity update(@PathVariable Long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = this.timeEntryRepository.update(timeEntryId, expected);
        if (timeEntry == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(timeEntry, HttpStatus.OK);
    }

    @GetMapping ("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(this.timeEntryRepository.list(), HttpStatus.OK);
    }

    public ResponseEntity delete(long timeEntryId) {
        this.timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
