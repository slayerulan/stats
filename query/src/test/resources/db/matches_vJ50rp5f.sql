-- Айлендерс	 - Колорадо 6.11  2-0, 3-2, 1-2

INSERT INTO PUBLIC.HOCKEY_TEAM
(ID, CHAMPIONSHIP, NAME)
VALUES(19, 'NHL', 'Айлендерс');


INSERT INTO PUBLIC.HOCKEY_BOOKIE_STATS
(ID, DRAW_RATE, GUEST_RATE, HOME_RATE)
VALUES(167, 4.35, 4.2, 1.66);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(665, 0, 2, 'FIRST', 2, 'HOME', 0, 0, 0, 12, 2, 0, 0, 8);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(903, 4, 'HOME', 5, 19);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(904, 12, 'HOME', 58, 19);


INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(665, 903);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(665, 904);



INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(666, 4, 6, 'MATCH', 10, 'HOME', 9, 0, 0, 35, 13, 2, 0, 28);



INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(667, 2, 3, 'SECOND', 5, 'HOME', 4, 0, 0, 11, 4, 2, 0, 9);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(905, 21, 'HOME', 33, 19);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(906, 20, 'GUEST', 40, 1);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(907, 24, 'HOME', 24, 19);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(908, 29, 'HOME', 46, 19);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(909, 33, 'GUEST', 2, 1);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(667, 905);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(667, 906);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(667, 907);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(667, 908);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(667, 909);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(668, 2, 1, 'THIRD', 3, 'GUEST', 5, 0, 0, 12, 7, 0, 0, 11);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(910, 59, 'GUEST', 30, 1);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(911, 41, 'HOME', 23, 19);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(912, 59, 'GUEST', 51, 1);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(668, 910);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(668, 911);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(668, 912);


INSERT INTO PUBLIC.HOCKEY_MATCH_INFO
(ID, FIRST_PERIOD_ID, MATCH_ID, SECOND_PERIOD_ID, THIRD_PERIOD_ID)
VALUES(167, 665, 666, 667, 668);


INSERT INTO PUBLIC.HOCKEY_MATCH
(ID, CHAMPIONSHIP, "DATE", MYSCORE_CODE, SEASON, BOOKIE_STATS_ID, GUEST_TEAM_ID, HOME_TEAM_ID, MATCH_INFO_ID)
VALUES(167, 'NHL', '2017-11-06 02:00:00.000', 'vJ50rp5f', 'S2017', 167, 1, 19, 167);




