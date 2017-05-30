package com.savik.parser;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LeagueItem {
    String countryId;
    String countryName;
    String leagueId;
}
