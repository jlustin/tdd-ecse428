package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ noArgsTest.class, validInputTest.class, lessThanSevenArgs.class, moreThanSevenArgs.class })
public class AllTests {

}
