package com.dmorozzov.timeobsrv.service;

import com.dmorozzov.timeobsrv.domain.dto.EventDto;
import com.dmorozzov.timeobsrv.domain.dto.EventGroupDto;
import com.dmorozzov.timeobsrv.domain.request.GroupEventRequest;

import java.util.List;


public interface EventService {
    List<EventGroupDto> findAllGroupEvents(GroupEventRequest eventRequest);
    Long saveEventGroup(EventGroupDto eventGroupDto);
    void saveEvent(EventDto eventDto);
}
