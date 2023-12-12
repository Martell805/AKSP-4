package com.example.aksp4;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class WebsController {
    @GetMapping
    @ResponseBody
    public String index() {
        return "go to /webs";
    }

    @GetMapping("/webs")
    public ModelAndView webs() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chat.html");

        return modelAndView;
    }

    @MessageMapping("/webs")
    @SendTo("/topic/webs-topic")
    public Message send(Message message) {
        System.out.println(message);
        return message;
    }
}
