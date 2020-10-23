package unittests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import pkg.JSONHolder;
import pkg.Order;

public class smithTest2 {

	@Test
	public void test() {
		Order o,o2;
		JSONHolder jh;


	
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
		jh = new JSONHolder(2);
		assertNotNull (jh);
	}

}
