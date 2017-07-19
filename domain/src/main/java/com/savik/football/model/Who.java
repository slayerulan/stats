package com.savik.football.model;

/**
 * @author Savushkin Yauheni
 * @since 10.4.17
 */
public enum Who {
    HOME,
    GUEST,
    UNKNOWN;

    public boolean isTeam() {
        return this.equals(HOME) || this.equals(GUEST);
    }
}
