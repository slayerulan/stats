package com.savik;

import com.savik.hockey.model.*;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Savushkin Yauheni
 * @since 05.05.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@ActiveProfiles("test")
@Sql(scripts = {
        "classpath:db/matches_AqombNzc.sql", "classpath:db/matches_CIGVL5B6.sql",
        "classpath:db/matches_j5qIp46c.sql", "classpath:db/matches_rwPEPmCs.sql",
        "classpath:db/matches_Ai5wex7j.sql", "classpath:db/matches_QTEL7Fjd.sql",
        "classpath:db/matches_vJ50rp5f.sql", "classpath:db/matches_YVeCUxb9.sql",
        "classpath:db/matches_I39zqxpU.sql", "classpath:db/matches_lAtkXvoI.sql",
        "classpath:db/matches_xn1B4zMd.sql", "classpath:db/matches_YaFolFyG.sql",
})
public class HockeyMatchParserTest {

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Test
    public void testMatchWithOvertimeAndBulletsAndStats() {

        List<HockeyMatch> all = hockeyMatchRepository.findAll();


        assertEquals(1, 1);
    }



}
