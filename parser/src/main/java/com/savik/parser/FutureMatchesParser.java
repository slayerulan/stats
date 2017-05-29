package com.savik.parser;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class FutureMatchesParser {


    public static final String JS_ROW_END = "~";
    public static final String JS_CELL_END = "¬";
    public static final String JS_INDEX = "????????????????";
    public static final String LEAGUE_INDEX = "ZA";
    public static final String EVENT_INDEX = "????????????";


    public static void main(String[] args) {

        String response = "";

        List<String> rows = Arrays.asList(response.split(JS_ROW_END));
        for (String s : rows) {
            List<String> row = Arrays.asList(s.split(JS_CELL_END));
            List<String> index = Arrays.asList(row.get(0).split(JS_INDEX));
            String indexName = null;
            String indexValue = null;
            if (!index.isEmpty() && StringUtils.hasLength(index.get(0))) {
                indexName = index.get(0);
            }
            if (index.size() > 2 && StringUtils.hasLength(index.get(1))) {
                indexValue = index.get(1);
            }

            if (LEAGUE_INDEX.equalsIgnoreCase(indexName)) {
                ///
            } else if (EVENT_INDEX.equalsIgnoreCase(indexName)) {
                //
            }

        }


    }
}
