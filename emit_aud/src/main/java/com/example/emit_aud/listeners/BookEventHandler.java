package com.example.emit_aud.listeners;

import com.example.emit_aud.model.events.BookCreatedEvent;
import com.example.emit_aud.servises.BookService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandler {

    private final BookService bookService;

    public BookEventHandler(BookService bookService) {
        this.bookService = bookService;
    }
    // ocekuva odreden nastan da se sluci
    @EventListener
    public void onBookCreated(BookCreatedEvent event){
        this.bookService.refreshMaterializedView();
    }
}
