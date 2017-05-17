package com.savik.football.blocks.total.over.match;

import java.util.Arrays;

import com.savik.football.blocks.GeneralBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class GuestOverBlock extends GeneralBetContainer {

    public GuestOverBlock() {
        super(Arrays.asList(
                new GuestOverSingleBlock(0),
                new GuestOverSingleBlock(1),
                new GuestOverSingleBlock(2),
                new GuestOverSingleBlock(3),
                new GuestOverSingleBlock(4)
        ));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
