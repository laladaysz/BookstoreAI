package com.bookstore.ai.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bookstore")
public class BookstoreAssistantController {

    private final ChatClient chatClient;

    public BookstoreAssistantController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient
                .defaultSystem("Tell me five best sellers from de lastest five years! ")
                .build();
    }

    @GetMapping("/informations")
    public String bookstoreChat(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();

    }
}
