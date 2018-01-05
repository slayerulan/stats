-- Детройт - Колорадо 20.11  1-1, 1-0, 1-2

INSERT INTO PUBLIC.HOCKEY_TEAM
(ID, CHAMPIONSHIP, NAME)
VALUES(17, 'NHL', 'Детройт');


INSERT INTO PUBLIC.HOCKEY_BOOKIE_STATS
(ID, DRAW_RATE, GUEST_RATE, HOME_RATE)
VALUES(75, 4.1, 3.6, 1.8);



INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(297, 1, 1, 'FIRST', 2, 'DRAW', 0, 0, 0, 12, 2, 0, 0, 7);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(398, 19, 'GUEST', 44, 21);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(399, 14, 'HOME', 1, 17);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(297, 398);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(297, 399);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, HOME_MINOR_PENALTIES_AMOUNT, GUEST_MINOR_PENALTIES_AMOUNT,PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(298, 3, 3, 6, 3, 'MATCH', 6, 'DRAW', 6, 1, 0, 37, 12, 1, 0, 24);


INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(299, 0, 1, 'SECOND', 1, 'HOME', 4, 0, 0, 12, 6, 0, 0, 7);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(400, 39, 'HOME', 3, 17);


INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(299, 400);

INSERT INTO PUBLIC.HOCKEY_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_PENALTIES_TIME, GUEST_POWERPLAY_GOALS, GUEST_SHOT_HANDED_GOALS, GUEST_SHOTS_ON_TARGET, HOME_PENALTIES_TIME, HOME_POWERPLAY_GOALS, HOME_SHOT_HANDED_GOALS, HOME_SHOTS_ON_TARGET)
VALUES(300, 2, 1, 'THIRD', 3, 'GUEST', 2, 1, 0, 11, 4, 1, 0, 10);


INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(401, 59, 'GUEST', 14, 21);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(402, 53, 'GUEST', 45, 21);

INSERT INTO PUBLIC.HOCKEY_GOAL
(ID, "MINUTE", WHO_SCORED, SECONDS, TEAM_ID)
VALUES(403, 51, 'HOME', 7, 17);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(300, 401);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(300, 402);

INSERT INTO PUBLIC.HOCKEY_PERIOD_GOALS
(HOCKEY_PERIOD_ID, GOALS_ID)
VALUES(300, 403);


INSERT INTO PUBLIC.HOCKEY_MATCH_INFO
(ID, FIRST_PERIOD_ID, MATCH_ID, SECOND_PERIOD_ID, THIRD_PERIOD_ID)
VALUES(75, 297, 298, 299, 300);

INSERT INTO PUBLIC.HOCKEY_MATCH
(ID, CHAMPIONSHIP, "DATE", MYSCORE_CODE, SEASON, BOOKIE_STATS_ID, GUEST_TEAM_ID, HOME_TEAM_ID, MATCH_INFO_ID)
VALUES(75, 'NHL', '2017-11-20 02:00:00.000', 'YVeCUxb9', 'S2017', 75, 21, 17, 75);



