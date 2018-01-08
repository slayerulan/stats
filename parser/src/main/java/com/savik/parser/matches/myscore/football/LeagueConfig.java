package com.savik.parser.matches.myscore.football;

import com.savik.Season;
import com.savik.football.model.FootballChampionship;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeagueConfig {

    Map<FootballChampionship, Map<Season, String>> map = new HashMap<FootballChampionship, Map<Season, String>>() {
        {
            put(FootballChampionship.LA, LA_MAP);
            put(FootballChampionship.SERIE_A, SERIE_A_MAP);
        }
    };

    private static final Map<Season, String> LA_MAP = Collections.unmodifiableMap(
            Stream.of(
                    entry(Season.S2016, "http://www.myscore.com.ua/football/spain/laliga/results/"),
                    entry(Season.S2015, "http://www.myscore.com.ua/football/spain/laliga-2015-2016/results/")
            ).collect(entriesToMap()));

    private static final Map<Season, String> SERIE_A_MAP = Collections.unmodifiableMap(
            Stream.of(
                    entry(Season.S2016, "http://www.myscore.com.ua/football/italy/serie-a/results/"),
                    entry(Season.S2015, "http://www.myscore.com.ua/football/italy/serie-a-2015-2016/results/")
            ).collect(entriesToMap()));

    public static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    public static <K, U> Collector<Map.Entry<K, U>, ?, Map<K, U>> entriesToMap() {
        return Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue());
    }

}
