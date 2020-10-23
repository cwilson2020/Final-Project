package unittests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import pkg.JSONHolder;
import pkg.JSONIter;
import pkg.Order;


public class JunitJSONHolderTest {
	public Order o,o2;
	public JSONHolder jh;


	public JunitJSONHolderTest(){
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
	public void testJSONHolder() {
		jh = new JSONHolder(2);
		assertNotNull (jh);
	}

	@Test
	public void testAdd() {
		jh = new JSONHolder(2);
		jh.add(o);

		Order[] orderArray =jh.getOrder();
		assertNotNull(orderArray);
	}



	@Test
	public void testGetOrderIndexByID() {
		jh = new JSONHolder(1);
		jh.add(o2);
		jh.add(o);
		jh.add(o2);
		int temp = jh.getOrderIndexByID(1);
		assertEquals(1, temp);
	}

	@Test
	public void testUpdate() {
		jh = new JSONHolder(2);
		jh.add(o);
		jh.add(o2);
		jh.update(0,o2);
		Order temp1 = jh.getByIndex(0);
		Order temp2 = jh.getByIndex(1);
		assertEquals(temp1, temp2);
	}

	@Test
	public void IterTest() {
		jh = new JSONHolder(2);
		jh.add(o);
		jh.add(o2);
				JSONIter ji = new JSONIter(jh.getOrder());
		int i =0;
		while (ji.hasNext()) {
			Order temp = ji.next();
			
			if(i ==0)
				assertEquals(o,temp);
			else
				assertEquals(o2,temp);
			i++;
		}
	}

	//JSONIter ji = new JSONIter(jh.getOrder());


}
