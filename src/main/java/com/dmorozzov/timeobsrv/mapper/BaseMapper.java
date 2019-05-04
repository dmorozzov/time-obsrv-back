package com.dmorozzov.timeobsrv.mapper;

import com.dmorozzov.timeobsrv.domain.dto.EventDto;
import com.dmorozzov.timeobsrv.domain.dto.EventGroupDto;
import com.dmorozzov.timeobsrv.domain.entity.Event;
import com.dmorozzov.timeobsrv.domain.entity.EventGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseMapper {
    EventDto event2EventDto(Event event);
    Event eventDto2Event(EventDto eventDto);
    EventGroup eventGroupDto2EventGroup(EventGroupDto eventGroupDto);
    EventGroupDto eventGroup2EventGroupDto(EventGroup eventGroup);
}
