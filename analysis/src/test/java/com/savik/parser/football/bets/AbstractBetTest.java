package com.savik.parser.football.bets;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("AbstractClassWithoutAbstractMethods")
@RunWith(SpringRunner.class)
public abstract class AbstractBetTest {

    @Before
    public void init() {

    }

}
