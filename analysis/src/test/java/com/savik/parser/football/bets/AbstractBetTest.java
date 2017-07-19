package com.savik.parser.football.bets;

import javax.transaction.Transactional;

import org.junit.Before;
import org.springframework.test.annotation.Rollback;

@SuppressWarnings("AbstractClassWithoutAbstractMethods")
@Transactional
@Rollback
public abstract class AbstractBetTest {
+
    @Before
    public void init() {

    }

}
