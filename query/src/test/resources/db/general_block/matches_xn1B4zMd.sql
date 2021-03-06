-- Филадельфия	 - Колорадо 05.11  0-1, 2-2, 2-1

INSERT INTO PUBLIC.HOCKEY_TEAM
(ID, CHAMPIONSHIP, NAME)
VALUES(26, 'NHL', 'Филадельфия');



INSERT INTO PUBLIC.HOCKEY_BOOKIE_STATS
(ID, DRAW_RATE, GUEST_RATE, HOME_RATE)
VALUES(179, 4, 3.2, 2);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(713, 1, 0, 'FIRST', 1, 'GUEST', 4, 1, 0, 9, 4, 0, 0, 5);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(972, 19, 'GUEST', 58, 1);


INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(713, 972);



INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(714, 4, 4, 'MATCH', 8, 'DRAW', 12, 2, 1, 27, 6, 1, 0, 37);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(715, 2, 2, 'SECOND', 4, 'DRAW', 6, 1, 1, 9, 2, 1, 0, 16);



INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(973, 36, 'GUEST', 13, 1);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(974, 21, 'HOME', 21, 26);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(975, 26, 'HOME', 31, 26);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(976, 35, 'GUEST', 30, 1);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(715, 973);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(715, 974);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(715, 975);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(715, 976);

INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(716, 1, 2, 'THIRD', 3, 'HOME', 2, 0, 0, 4, 0, 0, 0, 10);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(977, 46, 'HOME', 37, 26);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(978, 44, 'HOME', 33, 26);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(979, 45, 'GUEST', 37, 1);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(716, 977);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(716, 978);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(716, 979);


INSERT INTO PUBLIC.HOCKEY_MATCH_INFO
(ID, FIRST_PERIOD_ID, MATCH_ID, SECOND_PERIOD_ID, THIRD_PERIOD_ID)
VALUES(179, 713, 714, 715, 716);

INSERT INTO PUBLIC.HOCKEY_MATCH
(ID, CHAMPIONSHIP, "DATE", MYSCORE_CODE, SEASON, BOOKIE_STATS_ID, GUEST_TEAM_ID, HOME_TEAM_ID, MATCH_INFO_ID)
VALUES(179, 'NHL', '2017-11-05 02:00:00.000', 'xn1B4zMd', 'S2017', 179, 1, 26, 179);




