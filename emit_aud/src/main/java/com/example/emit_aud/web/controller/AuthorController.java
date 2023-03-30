//package com.example.emit_aud.web.controller;
//
//
//import com.example.emit_aud.servises.AuthorService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/author")
//public class AuthorController {
//
//    private final AuthorService manufacturerService;
//
//    public AuthorController(AuthorService manufacturerService) {
//        this.manufacturerService = manufacturerService;
//    }
//
//    @GetMapping
//    public String getCategoryPage(Model model){
//        model.addAttribute("authors", this.manufacturerService.findAll());
//        model.addAttribute("bodyContent", "authors");
//        return "master-template";
//    }
//}
