package com.example.emit_aud.job;


import com.example.emit_aud.servises.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final BookService bookService;

    public ScheduledTasks(BookService bookService) {
        this.bookService = bookService;
    }


    // na sekoj 5 sekundi ke se pravi refreshiranje na materiliziran view
    @Scheduled(fixedDelay = 5000)
    public void refreshMaterializedView(){
        // this.bookService.refreshMaterializedView();
    }
}