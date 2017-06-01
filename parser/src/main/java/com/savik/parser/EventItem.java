package com.savik.parser;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Builder
public class EventItem {

    String eventId;

    String homeName;

    String guestName;

    String leagueId;

    LocalDateTime eventDate;
}
