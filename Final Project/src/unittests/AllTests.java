package unittests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppModelTest.class, JParserTest.class, JunithelperFunctionsTest.class, JunitJSONHolderTest.class,
		OptionIterTest.class, JUnitOrderProxyTest.class, JUnitStatePatternTests.class, OptionTest.class, OrderTest.class, smithTest2.class })
public class AllTests {

}
