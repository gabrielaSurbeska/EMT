//package com.example.emit_aud.web.controller;
//
//
//import com.example.emit_aud.model.Author;
//import com.example.emit_aud.model.Book;
//import com.example.emit_aud.model.enumerations.CategoryType;
//import com.example.emit_aud.servises.AuthorService;
//import com.example.emit_aud.servises.BookService;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/products")
//public class BookController {
//
//    private final BookService bookService;
//    private final AuthorService authorService;
//   // private com.example.emit_aud.servises.AuthorService authorService;
//
//
//    public BookController(BookService bookService, AuthorService authorService) {
//        this.bookService = bookService;
//        this.authorService = authorService;
//    }
//
//    @GetMapping
//    public String getProductPage(@RequestParam(required = false) String error, Model model) {
//        if (error != null && !error.isEmpty()) {
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//        List<Book> books = this.bookService.findAll();
//        model.addAttribute("book", books);
//        model.addAttribute("bodyContent", "book");
//        return "master-template";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable Long id) {
//        this.bookService.deleteById(id);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/edit-form/{id}")
//    public String editProductPage(@PathVariable Long id, Model model) {
//        if (this.bookService.findById(id).isPresent()) {
//            Book book = this.bookService.findById(id).get();
//            List<Author> author = this.authorService.findAll();
//            model.addAttribute("author", author);
//            model.addAttribute("book", book);
//            model.addAttribute("bodyContent", "add-product");
//            return "master-template";
//        }
//        return "redirect:/products?error=ProductNotFound";
//    }
//
//    @GetMapping("/add-form")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String addProductPage(Model model) {
//        List<Author> authors = this.authorService.findAll();
//        model.addAttribute("authors", authors);
//
//        model.addAttribute("bodyContent", "add-product");
//        return "master-template";
//    }
//
//    @PostMapping("/add")
//    public String saveProduct(
//            @RequestParam(required = false) Long id,
//            @RequestParam String name,
//            @RequestParam CategoryType category,
//            @RequestParam Author author,
//            @RequestParam int availableCopies) {
//        if (id != null) {
//            this.bookService.edit(id, author, name , availableCopies, category );
//        } else {
//            this.bookService.save(id, name, category, author, availableCopies);
//        }
//        return "redirect:/products";
//    }
//}
