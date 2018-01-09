package com.savik.parser.coeffs.x1stavka.hockey;

import com.savik.CoeffContainer;
import com.savik.parser.coeffs.x1stavka.Book1xbetShortName;
import com.savik.parser.coeffs.x1stavka.Sport1xstavkaCoeffsMatchParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

import static com.savik.ContainerType.*;


@Service
class Hockey1xstavkaCoeffsMatchParser extends Sport1xstavkaCoeffsMatchParser {

    public void fill(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer rootContainer) {
        fillTotalBlock(futureMatchCoeffs, rootContainer.findByType(TOTAL));
        fillOtherBlock(futureMatchCoeffs, rootContainer.findByType(OTHER));
        fillStatsBlock(futureMatchCoeffs, rootContainer.findByType(STATS));
    }

    public void fillSpecialGroups(JSONObject matchCoeffsObject, CoeffContainer rootContainer) throws IOException {
        JSONArray specialGroups = matchCoeffsObject.getJSONObject("Value").getJSONArray("SG");

        fillPeriodBlock(
                getBookFutureMatchCoeffs(findPeriod(specialGroups, "1")),
                rootContainer.findByType(PERIODS).findByType(FIRST_PERIOD)
        );

        fillPeriodBlock(
                getBookFutureMatchCoeffs(findPeriod(specialGroups, "2")),
                rootContainer.findByType(PERIODS).findByType(SECOND_PERIOD)
        );


        fillPeriodBlock(
                getBookFutureMatchCoeffs(findPeriod(specialGroups, "3")),
                rootContainer.findByType(PERIODS).findByType(THIRD_PERIOD)
        );

        JSONObject shotsOnTarget = findSpecialGroupByTG(specialGroups, "Броски в створ ворот");
        if (shotsOnTarget != null) {
            fillShotsBlock(
                    getBookFutureMatchCoeffs(shotsOnTarget),
                    rootContainer.findByType(STATS)
            );
        }

        JSONObject penalties = findSpecialGroupByTG(specialGroups, "Штрафное время");
        if (shotsOnTarget != null) {
            fillPenaltiesBlock(
                    getBookFutureMatchCoeffs(penalties),
                    rootContainer.findByType(STATS).findByType(PENALTIES).findByType(MATCH)
            );
        }

        JSONObject firstPeriodPenalties = findSpecialGroupByTGAndPN(specialGroups, "Штрафное время",  "1-й  Период");
        if (shotsOnTarget != null) {
            fillPenaltiesBlock(
                    getBookFutureMatchCoeffs(firstPeriodPenalties),
                    rootContainer.findByType(STATS).findByType(PENALTIES).findByType(FIRST_PERIOD)
            );
        }

    }

    private void fillTotalBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalContainer) {
        fillTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                totalContainer.findByType(TOTAL_OVER));
        fillTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
                totalContainer.findByType(TOTAL_UNDER));

        fillBothTeamsTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_TOTAL_OVER_NO),
                totalContainer.findByType(BOTH_TEAMS_TOTAL_OVER));

        fillBothTeamsTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_TOTAL_UNDER_NO),
                totalContainer.findByType(BOTH_TEAMS_TOTAL_UNDER));

        fillTeamTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER),
                totalContainer.findByType(TEAM_TOTAL_OVER));

        fillTeamTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_UNDER),
                totalContainer.findByType(TEAM_TOTAL_UNDER));

        fillTeamTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER),
                totalContainer.findByType(OPPOSING_TEAM_TOTAL_OVER));

        fillTeamTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_UNDER),
                totalContainer.findByType(OPPOSING_TEAM_TOTAL_UNDER));

    }

    private void fillTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_5_5), "5.5");
        }
    }

    private void fillTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalUnderContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_5_5), "5.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_6_5), "6.5");
        }
    }

    private void fillBothTeamsTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                             Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                             CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_1_5), "1.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_2_5), "2.5")
        );
    }

    private void fillBothTeamsTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                              Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_3_5), "3.5")
        );
    }

    private void fillTeamTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer teamTotalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_3_5), "3.5");
        }
    }

    private void fillTeamTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer teamTotalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_3_5), "3.5");
        }
    }

    private void fillOtherBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalContainer) {
        fillTotalOverInAllPeriodsBlock(
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER_ALL_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER_ALL_PERIODS_NO),
                totalContainer.findByType(TOTAL_OVER_ALL_PERIODS));

        fillTotalUnderInAllPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER_ALL_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER_ALL_PERIODS_NO),
                totalContainer.findByType(TOTAL_UNDER_ALL_PERIODS));

        fillAnyWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_TEAM_WIN_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_TEAM_WIN_AND_TOTAL_OVER_NO),
                totalContainer.findByType(ANY_WIN_AND_TOTAL_OVER));

        fillAnyWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_TEAM_WIN_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_TEAM_WIN_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(ANY_WIN_AND_TOTAL_UNDER));

        fillAnyWinAndDiffExactlyEqualsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_WIN_AND_DIFFERENCE_EQUALS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_WIN_AND_DIFFERENCE_EQUALS_NO),
                totalContainer.findByType(ANY_WIN_AND_DIFFERENCE_EQUALS));

        fillAnyWinAndDiffEqualsOrMoreBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_WIN_AND_DIFFERENCE_EQUALS_OR_MORE_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_WIN_AND_DIFFERENCE_EQUALS_OR_MORE_NO),
                totalContainer.findByType(ANY_WIN_AND_DIFFERENCE_EQUALS));

        fillFirstGoalTimeBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.FIRST_GOAL_BEFORE_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.FIRST_GOAL_BEFORE_NO),
                totalContainer.findByType(FIRST_GOAL_BEFORE));

        fillLastGoalTimeBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.LAST_GOAL_AFTER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.LAST_GOAL_AFTER_NO),
                totalContainer.findByType(LAST_GOAL_AFTER));

        fillTeamWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AND_TOTAL_OVER_NO),
                totalContainer.findByType(TEAM_WIN_AND_TOTAL_OVER));

        fillTeamWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(TEAM_WIN_AND_TOTAL_UNDER));

        fillTeamWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE_AND_TOTAL_OVER_NO),
                totalContainer.findByType(TEAM_NOT_LOOSE_AND_TOTAL_OVER));

        fillTeamWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(TEAM_NOT_LOOSE_AND_TOTAL_UNDER));

        fillTeamWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AND_TOTAL_OVER_NO),
                totalContainer.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_OVER));

        fillTeamWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_UNDER));

        fillTeamWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER_NO),
                totalContainer.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER));

        fillTeamWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER));


        fillTeamTotalOverInAllPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER_ALL_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER_ALL_PERIODS_NO),
                totalContainer.findByType(TEAM_TOTAL_OVER_ALL_PERIODS));

        fillTeamTotalOverInAllPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS_NO),
                totalContainer.findByType(OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS));

        fillTeamWinAtLeastNPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AT_LEAST_N_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AT_LEAST_N_PERIODS_NO),
                totalContainer.findByType(TEAM_WIN_AT_LEAST_N_PERIODS));

        fillTeamWinAtLeastNPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS_NO),
                totalContainer.findByType(OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS));

        fillTeamWinAtLeast1PeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AT_LEAST_1_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AT_LEAST_1_PERIODS_NO),
                totalContainer.findByType(TEAM_WIN_AT_LEAST_N_PERIODS));

        fillTeamWinAtLeast1PeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AT_LEAST_1_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AT_LEAST_1_PERIODS_NO),
                totalContainer.findByType(OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS));

        fillDrawAtLeast1PeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.DRAW_AT_LEAST_1_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.DRAW_AT_LEAST_1_PERIODS_NO),
                totalContainer.findByType(DRAW_AT_LEAST_N_PERIODS));

        fillMostEffectivePeriodTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.MOST_EFFECTIVE_PERIOD_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.MOST_EFFECTIVE_PERIOD_TOTAL_OVER_NO),
                totalContainer.findByType(MOST_EFFECTIVE_PERIOD_TOTAL_OVER));

        fillTeamFirstScoredAndWinBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_FIRST_SCORED_AND_WIN_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_FIRST_SCORED_AND_WIN_NO),
                totalContainer.findByType(TEAM_FIRST_SCORED_AND_WIN));

        fillTeamFirstScoredAndWinBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_FIRST_SCORED_AND_WIN_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_FIRST_SCORED_AND_WIN_NO),
                totalContainer.findByType(OPPOSING_TEAM_FIRST_SCORED_AND_WIN));

        fillTeamScoredInRowBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_SCORED_IN_ROW_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_SCORED_IN_ROW_NO),
                totalContainer.findByType(TEAM_SCORED_N_IN_ROW));

        fillTeamScoredInRowBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_SCORED_IN_ROW_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_SCORED_IN_ROW_NO),
                totalContainer.findByType(OPPOSING_TEAM_SCORED_N_IN_ROW));

        fillPeriodXMoreEffectiveThanYBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.PERIOD_X_MORE_EFFECTIVE_THAN_Y_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.PERIOD_X_MORE_EFFECTIVE_THAN_Y_NO),
                totalContainer.findByType(PERIOD_X_MORE_EFFECTIVE_THAN_Y));

    }

    private void fillStatsBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalContainer) {

        fillPowerplayGoalsTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.POWERPLAY_GOALS_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.POWERPLAY_GOALS_TOTAL_OVER_NO),
                totalContainer.findByType(POWERPLAY_GOALS_OVER));


    }

    private void fillTotalOverInAllPeriodsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_0_5), "0.5")
        );
    }

    private void fillTotalUnderInAllPeriodsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                 Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                 CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_3_5), "3.5")
        );
    }

    private void fillAnyWinAndTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                             Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                             CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_5_5), "5.5")
        );
    }

    private void fillAnyWinAndTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                              Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_5_5), "5.5")
        );
    }

    private void fillAnyWinAndDiffExactlyEqualsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                     Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                     CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(DIFF_1), "1"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(DIFF_2), "2")
        );
    }

    private void fillAnyWinAndDiffEqualsOrMoreBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                    Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                    CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(DIFF_3_OR_MORE), "3")
        );
    }

    private void fillFirstGoalTimeBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                        Set<BookFutureMatchCoeff> futureMatchNegCoeffs, CoeffContainer container) {
        if (futureMatchPosCoeffs.size() == 0) {
            return;
        }
        if (futureMatchNegCoeffs.size() != 1) {
            throw new RuntimeException("strange");
        }
        BookFutureMatchCoeff negCoeff = futureMatchNegCoeffs.stream().findFirst().get();
        for (BookFutureMatchCoeff posCoeff : futureMatchPosCoeffs) {
            checkIfPosContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_9), "1.008");
            checkIfPosContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_10), "1.009");
            checkIfPosContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_11), "1.010");
            checkIfPosContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_12), "1.011");
        }
    }

    private void fillLastGoalTimeBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                       Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                       CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                //(posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_50), "1.05"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_55), "55.06")
        );
    }

    private void fillTeamWinAndTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                              Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_4_5), "4.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_5_5), "5.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_6_5), "6.5")
        );
    }

    private void fillTeamWinAndTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                               Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                               CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_4_5), "4.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_5_5), "5.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_6_5), "6.5")
        );
    }

    private void fillTeamTotalOverInAllPeriodsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                    Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                    CoeffContainer container) {
        setYesOrNoCoeff(futureMatchPosCoeffs, futureMatchNegCoeffs, container.findByType(OVER_0_5));
    }

    private void fillTeamWinAtLeastNPeriodsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                 Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                 CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(NUMBER_1), "1"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(NUMBER_2), "2")
        );
    }

    private void fillTeamWinAtLeast1PeriodsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                 Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                 CoeffContainer container) {
        setYesOrNoCoeff(futureMatchPosCoeffs, futureMatchNegCoeffs, container.findByType(NUMBER_1));
    }

    private void fillDrawAtLeast1PeriodsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                              Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        setYesOrNoCoeff(futureMatchPosCoeffs, futureMatchNegCoeffs, container.findByType(NUMBER_1));
    }


    private void fillMostEffectivePeriodTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                       Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                       CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_3_5), "3.5")
        );
    }

    private void fillTeamFirstScoredAndWinBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                CoeffContainer container) {
        if(futureMatchPosCoeffs.size() == 1 && futureMatchNegCoeffs.isEmpty()) {
            return;
        }
        setYesOrNoCoeff(futureMatchPosCoeffs, futureMatchNegCoeffs, container);
    }

    private void fillPeriodXMoreEffectiveThanYBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                    Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                    CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(P2_MORE_P1), "2.001"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(P3_MORE_P1), "3.001"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(P3_MORE_P2), "3.002")
        );
    }


    private void fillPowerplayGoalsTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                  Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                  CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_1_5), "1.5")
        );
    }

    private void fillTeamScoredInRowBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                          Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                          CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(NUMBER_2), "2"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(NUMBER_3), "3")
        );
    }

    private void fillPeriodBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer periodContainer) {

        fillPeriodDrawBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.DRAW),
                periodContainer.findByType(DRAW));

        fillPeriodAnyWinnerBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.ANY_WIN),
                periodContainer.findByType(ANY_WIN));

        fillPeriodTeamNotLooseBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE),
                periodContainer.findByType(TEAM_NOT_LOOSE));

        fillPeriodTeamNotLooseBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE),
                periodContainer.findByType(OPPOSING_TEAM_NOT_LOOSE));

        fillPeriodGoalBetweenBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.GOAL_BETWEEN_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.GOAL_BETWEEN_NO),
                periodContainer.findByType(GOAL_BETWEEN));

        fillPeriodTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                periodContainer.findByType(TOTAL_OVER));

        fillPeriodTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
                periodContainer.findByType(TOTAL_UNDER));


        fillPeriodTeamTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_UNDER),
                periodContainer.findByType(TEAM_TOTAL_OVER));

        fillPeriodTeamTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_UNDER),
                periodContainer.findByType(OPPOSING_TEAM_TOTAL_OVER));

        fillPeriodBothTeamsScoredBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_SCORED_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_SCORED_NO),
                periodContainer.findByType(BOTH_TEAMS_TOTAL_OVER));


    }

    private void fillShotsBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer statsContainer) {
        fillShotsTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
                statsContainer.findByType(SHOTS_ON_TARGET_OVER));

        fillTeamShotsHandicap(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_HANDICAP),
                statsContainer.findByType(TEAM_SHOTS_ON_TARGET_HANDICAP));

        fillTeamShotsHandicap(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_HANDICAP),
                statsContainer.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_HANDICAP));

        fillTeamWinShots(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN),
                statsContainer.findByType(TEAM_SHOTS_ON_TARGET_WIN));

        fillTeamWinShots(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN),
                statsContainer.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_WIN));

    }

    private void fillShotsTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                         Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                         CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_57_5), "57.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_58_5), "58.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_59_5), "59.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_60_5), "60.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_61_5), "61.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_62_5), "62.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_63_5), "63.5")
        );
    }

    private void fillTeamShotsHandicap(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            if (bookFutureMatchCoeff.getKind() == null) {
                continue;
            }
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(PLUS_5_5), "5.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(PLUS_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(PLUS_3_5), "3.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(PLUS_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(PLUS_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(MINUS_1_5), "-1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(MINUS_2_5), "-2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(MINUS_3_5), "-3.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(MINUS_4_5), "-4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(MINUS_5_5), "-5.5");
        }
    }

    private void fillTeamWinShots(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer container) {
        setYesCoeff(futureMatchCoeffs, container);
    }

    private void fillPeriodTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_0_5), "0.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_1_5), "1.5");
        }
    }

    private void fillPeriodTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_2_5), "2.5");
        }
    }

    private void fillPeriodDrawBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer container) {
        setYesCoeff(futureMatchCoeffs, container);
    }

    private void fillPeriodAnyWinnerBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer container) {
        setYesCoeff(futureMatchCoeffs, container);
    }

    private void fillPeriodTeamNotLooseBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer container) {
        setYesCoeff(futureMatchCoeffs, container);
    }

    private void fillPeriodGoalBetweenBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                            Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                            CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(BETWEEN_1_7), "1.007"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(BETWEEN_8_15), "8.015"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(BETWEEN_16_20), "16.02")
        );
    }

    private void fillPeriodTeamTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                              Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_0_5), "0.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_1_5), "1.5")
        );
    }

    private void fillPeriodBothTeamsScoredBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                CoeffContainer container) {
        setYesOrNoCoeff(futureMatchPosCoeffs, futureMatchNegCoeffs, container.findByType(OVER_0_5));

    }

    private void fillPenaltiesBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer statsContainer) {
        fillPenaltiesTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
                statsContainer.findByType(MINOR_PENALTIES_TIME_OVER));

        fillTeamPenaltiesTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_UNDER),
                statsContainer.findByType(TEAM_MINOR_PENALTIES_TIME_OVER));

        fillTeamPenaltiesTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_UNDER),
                statsContainer.findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_OVER));

        fillTeamNotLoosePenalties(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE),
                statsContainer.findByType(TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE));

        fillTeamNotLoosePenalties(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE),
                statsContainer.findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_NOT_LOOSE));

        fillTeamPenaltiesHandicap(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_HANDICAP),
                statsContainer.findByType(TEAM_MINOR_PENALTIES_TIME_HANDICAP));

        fillTeamPenaltiesHandicap(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_HANDICAP),
                statsContainer.findByType(OPPOSING_TEAM_MINOR_PENALTIES_TIME_HANDICAP));

    }

    private void fillPenaltiesTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                             Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                             CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_4_5), "4.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_6_5), "6.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_12_5), "12.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_14_5), "14.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_16_5), "16.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_18_5), "18.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_20_5), "20.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_22_5), "22.5")
        );
    }

    private void fillTeamPenaltiesHandicap(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            if (bookFutureMatchCoeff.getKind() == null) {
                continue;
            }
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(PLUS_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(PLUS_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(MINUS_2_5), "-2.5");
        }
    }

    private void fillTeamPenaltiesTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                 Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                 CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_0_5), "0.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_6_5), "6.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_7_5), "7.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_8_5), "8.5")
        );
    }

    private void fillTeamNotLoosePenalties(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer container) {
        setYesCoeff(futureMatchCoeffs, container);
    }

}

