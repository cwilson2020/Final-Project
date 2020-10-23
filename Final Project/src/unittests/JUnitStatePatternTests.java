package unittests;
import static org.junit.Assert.*;


import org.junit.Test;
import pkg.OrderStateBase;

public class JUnitStatePatternTests {

	@Test
	public void test() {
		OrderStateBase osb = new OrderStateBase();
		String s =osb.editOrder();
		System.out.println(s);
		assertEquals("Order open for editing", s);
	}

	@Test
	public void test1() {
		OrderStateBase osb = new OrderStateBase();
		String s = osb.cancelOrder();				
		System.out.println(s);
		assertEquals("OK", s);
	}
	@Test
	public void test2() {
		OrderStateBase osb = new OrderStateBase();
		//AppModel.getOrder().set
		String s =osb.fulfillOrder();
		System.out.println(s);
		assertEquals("Order will need to submitted first", s);
	}	
	@Test
	public void test2a() {
		OrderStateBase osb = new OrderStateBase();
		osb.submitOrder();
		String s = osb.fulfillOrder() ;
		System.out.println(s);
		assertEquals("OK", s);
	}
	@Test
	public void test2b() {
		OrderStateBase osb = new OrderStateBase();
		osb.submitOrder();
		osb.fulfillOrder() ;
		String s = osb.submitOrder();
		System.out.println(s);
		assertEquals("Order Already Submitted and fulfilled", s);
	}
	@Test
	public void test3() {
		OrderStateBase osb = new OrderStateBase();
		String s = osb.submitOrder();				
		System.out.println(s);
		assertEquals("OK", s);
	}	
	@Test
	public void test4() {
		OrderStateBase osb = new OrderStateBase();
		osb.submitOrder();
		osb.getEditOrder();
		String s = osb.submitOrder();				
		System.out.println(s);
		assertEquals("Order Already Submitted", s);
	}	
	@Test
	public void test5() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.submitOrder();
		osb.fulfillOrder();
		String s = osb.cancelOrder();					
		System.out.println("test5e: "+ s);
		assertEquals("Order has been fulfilled and can not be cancelled.\r\n" + 
				"Order Fulfilled\r\n" + 
				"Order already fulfilled", s);
		
	}	
	@Test
	public void test6() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.submitOrder();
		osb.fulfillOrder();
		String s = osb.fulfillOrder();					
		System.out.println("test6:" + a+  s);
		assertEquals("Order already fulfilled", s);
	}
	@Test
	public void test7() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.submitOrder();
		osb.fulfillOrder();
		String s = osb.editOrder();					
		System.out.println("test7:" + a+  s);
		assertEquals("Order Already Submitted and fulfilled",s);
	}
	@Test
	public void test8() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.submitOrder();
		String s = osb.submitOrder();					
		System.out.println("test8:" + a+  s);
		assertEquals("Order Already Submitted", s);
	}
	@Test
	public void test9() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.submitOrder();
		String s = osb.editOrder();					
		System.out.println("test9:" + a+  s);
		assertEquals("OK", s);
	}
	@Test
	public void test10() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.submitOrder();
		String s = osb.cancelOrder();					
		System.out.println("test10:" + a+  s);
		assertEquals("OK", s);
	}
	@Test
	public void test11() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.cancelOrder();
		String s = osb.cancelOrder();					
		System.out.println("test11:" + s);
		assertEquals("Order has already been cancelled", s);
	}
			
	@Test
	public void test12() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.cancelOrder();
		String s = osb.fulfillOrder();					
		System.out.println("test12:" + s);
		assertEquals("A canceled order can not be fulfilled", s);
	}
	@Test		
	public void test13() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.cancelOrder();
		String s = osb.submitOrder();					
		System.out.println("test13:" + s);
		assertEquals("Order has been canceled therefore can not be submitted.", s);
	}
	@Test
	public void test14() {
		OrderStateBase osb = new OrderStateBase();	
		String a = osb.cancelOrder();
		String s = osb.editOrder();					
		System.out.println("test14:" + s);
		assertEquals("OK", s);
	}
}
