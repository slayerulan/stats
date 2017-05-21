package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.over.match.MatchLoserOver;
import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchLooserUnderSingleBlock extends GeneralBetContainer {

    public MatchLooserUnderSingleBlock(int amount) {
        super(new MatchLoserOver(amount));
    }


}
