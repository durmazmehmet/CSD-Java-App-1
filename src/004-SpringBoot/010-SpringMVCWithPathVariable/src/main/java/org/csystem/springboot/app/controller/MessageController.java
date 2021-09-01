package org.csystem.springboot.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/message/{id}")
    public String displayMessageWithId(@PathVariable("id") int messageId)
    {
        return "Int Message:" + messageId;
    }

    @GetMapping("/lmessage/{id}")
    public String displayMessageWithLongId(@PathVariable("id") long messageId)
    {
        return "Long Message:" + messageId;
    }
}
