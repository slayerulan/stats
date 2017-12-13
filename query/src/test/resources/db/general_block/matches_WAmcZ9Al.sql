-- Баффало - Детройт 25.10  0-0, 1-0, 0-0


INSERT INTO PUBLIC.HOCKEY_TEAM
(ID, CHAMPIONSHIP, NAME)
VALUES(21, 'NHL', 'Баффало');



INSERT INTO PUBLIC.HOCKEY_BOOKIE_STATS
(ID, DRAW_RATE, GUEST_RATE, HOME_RATE)
VALUES(250, 3.75, 2.7, 2.35);




INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(997, 0, 0, 'FIRST', 0, 'DRAW', 2, 0, 0, 10, 0, 0, 0, 12);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(998, 0, 1, 'MATCH', 1, 'HOME', 10, 0, 0, 32, 6, 0, 0, 32);



INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(999, 0, 1, 'SECOND', 1, 'HOME', 4, 0, 0, 10, 2, 0, 0, 13);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(1405, 29, 'HOME', 45, 21);


INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(999, 1405);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(1000, 0, 0, 'THIRD', 0, 'DRAW', 4, 0, 0, 12, 4, 0, 0, 7);

INSERT INTO PUBLIC.HOCKEY_MATCH_INFO
(ID, FIRST_PERIOD_ID, MATCH_ID, SECOND_PERIOD_ID, THIRD_PERIOD_ID)
VALUES(250, 997, 998, 999, 1000);


INSERT INTO PUBLIC.HOCKEY_MATCH
(ID, CHAMPIONSHIP, "DATE", MYSCORE_CODE, SEASON, BOOKIE_STATS_ID, GUEST_TEAM_ID, HOME_TEAM_ID, MATCH_INFO_ID)
VALUES(250, 'NHL', '2017-10-25 02:30:00.000', 'WAmcZ9Al', 'S2017', 250, 17, 21, 250);



