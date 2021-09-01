package org.csystem.springboot.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @GetMapping
    public String displayMessage()
    {
        return "MyMessage";
    }

    @GetMapping("/message")
    public String displayMessage2()
    {
        return "MyMessage2";
    }
}
