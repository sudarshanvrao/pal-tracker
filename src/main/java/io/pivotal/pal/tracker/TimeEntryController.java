package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = this.timeEntryRepository.create(timeEntryToCreate);
        return ResponseEntity.created(null).body(timeEntry);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        TimeEntry timeEntry = this.timeEntryRepository.find(timeEntryId);
        if (timeEntry != null) {
            return ResponseEntity.ok(timeEntry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok(timeEntryRepository.list());
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry timeEntryToUpdate) {
        TimeEntry update = timeEntryRepository.update(timeEntryId, timeEntryToUpdate);
        if(null!=update)
            return ResponseEntity.ok(update);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
