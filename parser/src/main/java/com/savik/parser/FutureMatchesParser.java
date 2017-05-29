package com.savik.parser;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FutureMatchesParser {


    public static final String JS_ROW_END = "~";
    public static final String JS_CELL_END = "¬";
    public static final String JS_INDEX = "÷";
    public static final String LEAGUE_INDEX = "ZA";
    public static final String EVENT_INDEX = "AA";


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
                Map<String, String> tmp = new HashMap<>();
                for (int i = 0; i < row.size(); i++) {
                    List<String> rowParts = Arrays.asList(row.get(i).split(JS_INDEX));
                    if(rowParts.size() == 2) {
                        tmp.put(rowParts.get(0), rowParts.get(1));
                    }
                }
                // convert to league entity
            } else if (EVENT_INDEX.equalsIgnoreCase(indexName)) {

                Map<String, String> tmp = new HashMap<>();
                for (int i = 1; i < row.size(); i++) {
                    List<String> rowParts = Arrays.asList(row.get(i).split(JS_INDEX));
                    if(rowParts.size() == 2) {
                        tmp.put(rowParts.get(0), rowParts.get(1));
                    }
                }
                // CX - Домашнаяя, AF - гости, AA - id

            }

        }


    }
}


/*
*
* Data_LeagueItem.prototype.getSortKey = function(type) {
            return this.getValue('ZX')
        }
        ;
        Data_LeagueItem.prototype.hasTable = function() {
            return parseInt(this.getValue('ZG')) === 1
        }
        ;
        Data_LeagueItem.prototype.hasLiveTable = function() {
            return parseInt(this.getValue('ZO')) === 1
        }
        ;
        Data_LeagueItem.prototype.hasDraw = function() {
            return parseInt(this.getValue('ZG')) === 2
        }
        ;
        Data_LeagueItem.prototype.getTitle = function() {
            return this.getValue('ZA')
        }
        ;
        Data_LeagueItem.prototype.getCountryId = function() {
            return this.getValue('ZB')
        }
        ;
        Data_LeagueItem.prototype.getCountryName = function() {
            return this.getValue('ZY')
        }
        ;
        Data_LeagueItem.prototype.getTournamentId = function() {
            return this.getValue('ZE')
        }
        ;
        Data_LeagueItem.prototype.getTournamentTemplateId = function() {
            return this.getValue('ZEE')
        }
        ;
        Data_LeagueItem.prototype.getTournamentStageId = function() {
            return this.getValue('ZC')
        }
        ;
        Data_LeagueItem.prototype.getStageId = function() {
            return this.getValue('ZC')
        }
        ;
        Data_LeagueItem.prototype.getStagesCount = function() {
            return this.getValue('ZCC')
        }
        ;
        Data_LeagueItem.prototype.getTournamentType = function() {
            return this.getValue('ZD')
        }
        ;
        Data_LeagueItem.prototype.getTournamentStageType = function() {
            return this.getValue('ZJ')
        }
        ;
        Data_LeagueItem.prototype.getTournamentTemplateKey = function() {
            return this.getValue('ZH')
        }
        ;
        Data_LeagueItem.prototype.getTournamentTemplateName = function() {
            return this.getValue('ZK')
        }
        ;
        Data_LeagueItem.prototype.getTournamentTemplateAcronym = function() {
            return this.getValue('ZAC')
        }
        ;
        Data_LeagueItem.prototype.getStageName = function() {
            return this.getValue('ZAE')
        }
        ;
        Data_LeagueItem.prototype.getSuperTemplateId = function() {
            return this.getValue('ZHS')
        }
        ;
        Data_LeagueItem.prototype.getRaceType = function() {
            return this.getValue('ZM')
        }
        ;
*
*
* */
