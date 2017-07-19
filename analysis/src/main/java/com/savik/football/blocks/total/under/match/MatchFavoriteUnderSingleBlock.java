package com.savik.football.blocks.total.under.match;

import com.savik.football.bets.total.under.PeriodFavoriteUnder;
import com.savik.football.blocks.MatchPeriodFavoriteBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class MatchFavoriteUnderSingleBlock extends MatchPeriodFavoriteBetContainer {

    public MatchFavoriteUnderSingleBlock(double amount) {
        super(new PeriodFavoriteUnder(amount));
    }


}
