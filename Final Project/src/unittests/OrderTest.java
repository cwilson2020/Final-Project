package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import pkg.Order;

public class OrderTest {
	Order order = new Order();
public OrderTest(){
			
		order.setStatus("open");
		order.setName("TestName");
		order.setTrim("Value");
		order.setPrice(100);
		order.setOption_price(200);
		
	
}
	@Test
	public void Status() {
String[] options = {"Seats", "Radio"}; //new String[2];
	order.setOptions(options);
		assertEquals("TestName", order.getName());
		assertEquals(200, order.getOption_price());
		assertEquals(100, order.getPrice());
		assertEquals("open", order.getStatus());
		assertEquals("Value", order.getTrim());
		assertArrayEquals(options, order.getOptions());
	}

}
