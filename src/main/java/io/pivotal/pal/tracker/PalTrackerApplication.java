package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PalTrackerApplication {

    public TimeEntryRepository getTimeEntryRepo(){
        return new InMemoryTimeEntryRepository();
    }

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class
        ,args);
    }
}
