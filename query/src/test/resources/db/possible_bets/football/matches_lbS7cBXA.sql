--  Барселона	3-0	Леванте lbS7cBXA
INSERT INTO PUBLIC.FOOTBALL_TEAM (ID, NAME, CHAMPIONSHIP) VALUES(8, 'Барселона', 'LA');
INSERT INTO PUBLIC.FOOTBALL_TEAM (ID, NAME, CHAMPIONSHIP) VALUES(9, 'Леванте', 'LA');


INSERT INTO PUBLIC.FOOTBALL_BOOKIE_STATS
(ID, DRAW_RATE, GUEST_RATE, HOME_RATE)
VALUES(7, 15, 34, 1.05);

INSERT INTO PUBLIC.FOOTBALL_REFEREE
(ID, NAME)
VALUES(7, 'Дель Серро К. (Исп)');


INSERT INTO PUBLIC.FOOTBALL_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_CORNERS, GUEST_FOULS, GUEST_HITS, GUEST_HITS_ON_TARGET, GUEST_OFFSIDES, GUEST_POSSESSION, HOME_CORNERS, HOME_FOULS, HOME_HITS, HOME_HITS_ON_TARGET, HOME_OFFSIDES, HOME_POSSESSION)
VALUES(13, 0, 2, 'FIRST', 2, 'HOME', 3, 10, 4, 0, 2, 25, 1, 3, 11, 6, 3, 75);

INSERT INTO PUBLIC.FOOTBALL_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_CORNERS, GUEST_FOULS, GUEST_HITS, GUEST_HITS_ON_TARGET, GUEST_OFFSIDES, GUEST_POSSESSION, HOME_CORNERS, HOME_FOULS, HOME_HITS, HOME_HITS_ON_TARGET, HOME_OFFSIDES, HOME_POSSESSION)
VALUES(15, 0, 1, 'SECOND', 1, 'HOME', 3, 12, 5, 2, 0, 31, 2, 7, 5, 2, 2, 69);

INSERT INTO PUBLIC.FOOTBALL_PERIOD
(ID, GUEST_SCORE, HOME_SCORE, PERIOD_STATUS, TOTAL_SCORE, WINNER, GUEST_CORNERS, GUEST_FOULS, GUEST_HITS, GUEST_HITS_ON_TARGET, GUEST_OFFSIDES, GUEST_POSSESSION, HOME_CORNERS, HOME_FOULS, HOME_HITS, HOME_HITS_ON_TARGET, HOME_OFFSIDES, HOME_POSSESSION)
VALUES(14, 0, 3, 'MATCH', 3, 'HOME', 6, 22, 9, 2, 2, 28, 3, 10, 16, 8, 5, 72);

INSERT INTO PUBLIC.FOOTBALL_MATCH_INFO
(ID, FIRST_PERIOD_ID, MATCH_ID, SECOND_PERIOD_ID)
VALUES(7, 13, 14, 15);


INSERT INTO PUBLIC.FOOTBALL_MATCH
(ID, CHAMPIONSHIP, "DATE", MYSCORE_CODE, SEASON, BOOKIE_STATS_ID, GUEST_TEAM_ID, HOME_TEAM_ID, MATCH_INFO_ID, REFEREE_ID)
VALUES(7, 'LA', '2018-01-07 18:15:00.000', 'lbS7cBXA', 'S2017', 7, 9, 8, 7, 7);


INSERT INTO PUBLIC.FOOTBALL_CARD (ID, MINUTE, TYPE, WHO, TEAM_ID) VALUES (20, 8, 'YELLOW', 'GUEST', 9);
INSERT INTO PUBLIC.FOOTBALL_CARD (ID, MINUTE, TYPE, WHO, TEAM_ID) VALUES (21, 31, 'YELLOW', 'GUEST', 9);
INSERT INTO PUBLIC.FOOTBALL_CARD (ID, MINUTE, TYPE, WHO, TEAM_ID) VALUES (22, 70, 'YELLOW', 'GUEST', 9);
INSERT INTO PUBLIC.FOOTBALL_CARD (ID, MINUTE, TYPE, WHO, TEAM_ID) VALUES (23, 84, 'YELLOW', 'GUEST', 9);

INSERT INTO PUBLIC.FOOTBALL_PERIOD_CARDS (FOOTBALL_PERIOD_ID, CARDS_ID) VALUES (13, 20);
INSERT INTO PUBLIC.FOOTBALL_PERIOD_CARDS (FOOTBALL_PERIOD_ID, CARDS_ID) VALUES (13, 21);
INSERT INTO PUBLIC.FOOTBALL_PERIOD_CARDS (FOOTBALL_PERIOD_ID, CARDS_ID) VALUES (15, 22);
INSERT INTO PUBLIC.FOOTBALL_PERIOD_CARDS (FOOTBALL_PERIOD_ID, CARDS_ID) VALUES (15, 23);
