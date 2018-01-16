package com.savik.parser.squads.myscore.football;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FutureMatchSquadPlayer {

    private String name;

    private String myscoreUrlName;

    private String myscoreCode;

    private Boolean isLineUp;
}
