package com.dmorozzov.timeobsrv.controller;

import com.dmorozzov.timeobsrv.domain.dto.EventDto;
import com.dmorozzov.timeobsrv.domain.dto.EventGroupDto;
import com.dmorozzov.timeobsrv.domain.request.GroupEventRequest;
import com.dmorozzov.timeobsrv.security.CurrentUserPrinciple;
import com.dmorozzov.timeobsrv.security.UserPrincipal;
import com.dmorozzov.timeobsrv.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/event", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/groups")
    public List<EventGroupDto> fetchEventsByGroup(@CurrentUserPrinciple UserPrincipal userPrincipal,
                                                  @RequestBody GroupEventRequest eventRequest) {
        return eventService.findAllGroupEvents(eventRequest);
    }

    @PostMapping("/group-save")
    public Long saveEventGroup(@RequestBody EventGroupDto eventGroupDto) {
        return eventService.saveEventGroup(eventGroupDto);
    }

    @PostMapping("/save")
    public void saveEvent(@RequestBody @NotNull EventDto eventDto) {
        eventService.saveEvent(eventDto);
    }
}
