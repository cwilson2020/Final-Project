package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import pkg.Option;
import pkg.OptionArray;
import pkg.OptionIter;
import pkg.Order;
import pkg.helperFunctions;

public class OptionIterTest {
	Order o,o2;

	public OptionIterTest() {
		o = new Order();	
		o.setId(1);
		o.setName("TestName");
		o.setPrice(1000);
		o.setStatus("Editing");
		o.setTrim("Common");

		o2 = new Order();	
		o2.setId(2);
		o2.setName("TestName2");
		o2.setPrice(2000);
		o2.setStatus("Fulfilled");
		o2.setTrim("Value");	
	}

	@Test
	public void testOptionIter() {
		OptionIter iter = new OptionIter(helperFunctions.buildExtremeOptions().getOption());
		int i =0;
		while (iter.hasNext()) {
			String s = iter.next().getName();
			assertEquals(helperFunctions.buildExtremeOptions().getOption()[i].getName(),s);
			i++;
		}
	}


	@Test
	public void testGetSize() {
		OptionIter iter = new OptionIter(helperFunctions.buildCommonOptions().getOption());
			
		Option[] aa =helperFunctions.buildCommonOptions().getOption();
		System.out.println(aa.length +"   " + iter.getSize());
		
		assertEquals(aa.length, iter.getSize());
		Option[] empty = new Option[1];
		empty[0] = null;
		iter = new OptionIter(empty);
		boolean  b = iter.hasNext();
		assertEquals(false, b);
	}

}
