package com.dmorozzov.timeobsrv.util;

import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

@Component("auditDateTimeProvider")
public class AuditDateTimeProvider implements DateTimeProvider {
    @Override
    @NotNull
    public Optional<TemporalAccessor> getNow() {
        return Optional.of(ZonedDateTime.now());
    }

}
