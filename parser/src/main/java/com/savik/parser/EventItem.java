package com.savik.parser;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class EventItem {
    String eventId;
    String homeName;
    String guestName;
    LocalDateTime eventDate;
}
