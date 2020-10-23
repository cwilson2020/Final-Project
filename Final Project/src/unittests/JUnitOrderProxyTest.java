package unittests;



import static org.junit.Assert.*;

import org.junit.Test;

import pkg.AppModel;
import pkg.Order;
import pkg.OrderProxy;

public class JUnitOrderProxyTest {

	public OrderProxy op;
	public Order o;

	public JUnitOrderProxyTest(){
		op = new OrderProxy();
		o = new Order();	
		o.setId(1);
		o.setName("TestName");
		o.setPrice(1000);
		o.setStatus("Editing");
		o.setTrim("Common");


	}

	@Test
	public void testGetStatus() {
		AppModel.setOrder(o);		
		String s = op.getStatus();
		System.out.println("test get status: " + s);
		assertEquals("", s);
		s = op.getStatus();
	}

	@Test
	public void testSetstatus() {
		AppModel.setOrder(o);	
		String s = op.setstatus("Dealer", "Open");	
		System.out.println("test Set status: " + s);
		assertEquals("No state change a dealer can't issue a reorder",s);
}
	@Test
	public void testSetstatus2() {
		AppModel.setOrder(o);	
		String s = op.setstatus("Customer", "Fulfill");	
		System.out.println("test Set status2: " + s);
		assertEquals("No state change a customer can't fulfill an order",s);
}
		@Test
		public void testSetstatus3() {
		AppModel.setOrder(o);	
		String s = op.setstatus("Dealer", "Fulfill");	
		System.out.println("test Set status3: " + s);
		assertEquals("Order State Changed",s);
}


}
