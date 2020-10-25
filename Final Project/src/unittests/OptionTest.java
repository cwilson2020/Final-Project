package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import pkg.Option;

public class OptionTest {

	Option option; 
	public OptionTest() {
		option = new Option();
		option.setAlaCartePrice(100);
		option.setDescription("testDescription");
		option.setName("testName");
		option.setPackagePrice(200);
	}

	@Test
	public void testGetName() {
		assertEquals("testName",option.getName());
	}

	@Test
	public void testGetPackagePrice() {
		assertEquals(200,option.getPackagePrice());
	}

	@Test
	public void testGetAlaCartePrice() {
		assertEquals(100,option.getAlaCartePrice());
	}

	@Test
	public void testGetDescription() {
		assertEquals("testDescription",option.getDescription());
	}

}
