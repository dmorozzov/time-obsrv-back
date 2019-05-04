package com.dmorozzov.timeobsrv.controller;

import com.dmorozzov.timeobsrv.domain.dto.EventDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.ZonedDateTime;

@Controller
public class NotifyController {

    @MessageMapping("/check")
    @SendTo("/topic/events")
    public EventDto check(EventDto message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new EventDto(1L, "test", ZonedDateTime.now());
    }
}
