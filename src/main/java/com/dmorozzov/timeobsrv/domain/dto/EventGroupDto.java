package com.dmorozzov.timeobsrv.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EventGroupDto {
    private Long id;
    private String name;
    private ZonedDateTime createdAt;
    private List<EventDto> events = new ArrayList<>();
}
