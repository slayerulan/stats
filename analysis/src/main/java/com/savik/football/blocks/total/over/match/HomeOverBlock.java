package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class HomeOverBlock extends GeneralBetContainer {

    public HomeOverBlock() {
        super(Arrays.asList(
                new HomeOverSingleBlock(0),
                new HomeOverSingleBlock(1),
                new HomeOverSingleBlock(2),
                new HomeOverSingleBlock(3),
                new HomeOverSingleBlock(4)
        ));
    }


}
