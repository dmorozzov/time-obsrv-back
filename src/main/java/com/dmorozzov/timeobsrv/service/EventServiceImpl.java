package com.dmorozzov.timeobsrv.service;

import com.dmorozzov.timeobsrv.domain.dto.EventDto;
import com.dmorozzov.timeobsrv.domain.dto.EventGroupDto;
import com.dmorozzov.timeobsrv.domain.entity.Event;
import com.dmorozzov.timeobsrv.domain.request.GroupEventRequest;
import com.dmorozzov.timeobsrv.mapper.BaseMapper;
import com.dmorozzov.timeobsrv.repository.EventGroupRepository;
import com.dmorozzov.timeobsrv.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventGroupRepository eventGroupRepository;

    @Autowired
    private BaseMapper mapper;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    @Transactional
    public List<EventGroupDto> findAllGroupEvents(GroupEventRequest eventRequest) {
        return eventGroupRepository.findAll().stream()
                .map(event -> mapper.eventGroup2EventGroupDto(event))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long saveEventGroup(EventGroupDto eventGroupDto) {
        return 1L;
    }

    @Override
    @Transactional
    public void saveEvent(EventDto eventDto) {
        Event event = mapper.eventDto2Event(eventDto);
        eventRepository.save(event);
    }
}
