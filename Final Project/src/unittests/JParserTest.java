package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import pkg.JParser;
import pkg.Order;

public class JParserTest {

	@Test
	public void testStringtoObj() {
		JParser jp = new JParser();
		String json = "{\"Id\":130,\"name\":\"qwqwq\",\"trim\":\"Value\",\"options\":[],\"price\":25000,\"status\":\"Submitted\",\"option_price\":0}";
		Order order = jp.StringtoObj(json);
		Order o = new Order();
		o.setId(130);
		
		assertEquals(o.getId(), order.getId());
		
	}

}
