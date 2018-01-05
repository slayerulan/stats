-- Нэшвилл - Колорадо  19.11  1-0, 2-0, 2-2

INSERT INTO PUBLIC.HOCKEY_TEAM
(ID, CHAMPIONSHIP, NAME)
VALUES(15, 'NHL', 'Нэшвилл');


INSERT INTO PUBLIC.HOCKEY_BOOKIE_STATS
(ID, DRAW_RATE, GUEST_RATE, HOME_RATE)
VALUES(79, 4.25, 3.75, 1.8);



INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(313, 0, 1, 'FIRST', 1, 'HOME', 2, 0, 0, 10, 21, 1, 0, 10);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(420, 19, 'HOME', 25, 15);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(313, 420);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, HOME_MINOR_PENALTIES_AMOUNT, GUEST_MINOR_PENALTIES_AMOUNT,PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(314, 2, 5, 6, 4, 'MATCH', 7, 'HOME', 8, 0, 0, 31, 27, 2, 0, 24);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(315, 0, 2, 'SECOND', 2, 'HOME', 4, 0, 0, 8, 6, 0, 0, 9);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(421, 30, 'HOME', 38, 15);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(422, 29, 'HOME', 11, 15);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(315, 421);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(315, 422);




INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(316, 2, 2, 'THIRD', 4, 'DRAW', 2, 0, 0, 13, 0, 1, 0, 5);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(423, 58, 'GUEST', 15, 21);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(424, 47, 'HOME', 53, 15);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(425, 55, 'GUEST', 23, 21);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(426, 51, 'HOME', 51, 15);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(316, 423);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(316, 424);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(316, 425);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(316, 426);


INSERT INTO PUBLIC.HOCKEY_MATCH_INFO
(ID, FIRST_PERIOD_ID, MATCH_ID, SECOND_PERIOD_ID, THIRD_PERIOD_ID)
VALUES(79, 313, 314, 315, 316);


INSERT INTO PUBLIC.HOCKEY_MATCH
(ID, CHAMPIONSHIP, "DATE", MYSCORE_CODE, SEASON, BOOKIE_STATS_ID, GUEST_TEAM_ID, HOME_TEAM_ID, MATCH_INFO_ID)
VALUES(79, 'NHL', '2017-11-19 04:00:00.000', 'QTEL7Fjd', 'S2017', 79, 21, 15, 79);



