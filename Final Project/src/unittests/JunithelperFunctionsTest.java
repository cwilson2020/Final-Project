package unittests;



import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import pkg.OptionArray;
import pkg.helperFunctions;

public class JunithelperFunctionsTest {

	@Test
	public 	void helperfunction() {
		helperFunctions hf = new helperFunctions();
		assertNotNull(hf, () -> "instance should be created");
	}

	@Test
	public void testBuildFactoryOptions() {
		OptionArray a =	helperFunctions.buildFactoryOptions();
		assertNotNull(a, () -> "an array should be returned ");
	}

	@Test
	public void testBuildCommonOptions() {
		OptionArray a =	helperFunctions.buildCommonOptions();
		assertNotNull(a, () -> "an array should be returned ");
	}

	@Test
	public void testBuildExtremeOptions() {
		OptionArray a =	helperFunctions.buildExtremeOptions();
		assertNotNull(a, () -> "an array should be returned ");
	}

	@Test
	public void testSearchArray() {
		String[]array = new String [2];
		array[0] = "Non Matching test";
		array[1] = "Test Method";
		int a = helperFunctions.SearchArray(array, "Test");
		assertEquals(1, a);
	}
	@Test
	public	void testSearchArray2() {
		String[]array = new String [1];
		array[0] = "Non Matching test";		
		int a = helperFunctions.SearchArray(array, "Test");
		assertSame(-1, a);

	}
}
