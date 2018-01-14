package com.savik.filters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchFilter {

    private Long homeId;

    private Long guestId;

    private Long refereeId;

    private String myscoreCode;

    private boolean includeAllMatches;

    private Integer size;

}
