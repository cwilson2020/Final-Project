package unittests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JunithelperFunctionsTest.class, JunitJSONHolderTest.class, JUnitOrderProxyTest.class,
		JUnitStatePatternTests.class })
public class AllTests {

}
