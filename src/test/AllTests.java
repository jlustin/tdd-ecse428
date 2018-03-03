package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ validInputTest.class, validUpperLowerFromPostalCode.class, validUpperLowerToPostalCode.class,
	validUpperLowerPostType.class, noArgsTest.class, lessThanSevenArgs.class, moreThanSevenArgs.class, invalidFromPostalCode.class, 
	invalidToPostalCode.class, /*invalidPostType.class */
	})
public class AllTests {

}
