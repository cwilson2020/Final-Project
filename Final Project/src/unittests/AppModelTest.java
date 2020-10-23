package unittests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import pkg.AppModel;
import pkg.JSONHolder;
import pkg.Order;

public class AppModelTest {

	@Test
	public void testAppModel() {

	}

	@Test
	public void testAppModelJSONHolderOrder() {
		Order order = new Order ();
		AppModel.setOrder(order);
		Order o = AppModel.getOrder();
		assertEquals(o, order);
	}

	@Test
	public void testSetGetJh() {
		JSONHolder jh = new JSONHolder(0);
		AppModel.setJh(jh);
		JSONHolder jh2 = AppModel.getJh();
		assertSame(jh, jh2);
	}

	@Test
	public void testFile() {
		File file = new File("Test");
		AppModel.setFile(file);
		File temp = AppModel.getFile();
		assertEquals(temp, file);
	}

	@Test
	public void Current_user() {
		AppModel.setCurrent_user("TestUser");
		String temp = AppModel.getCurrent_user();
		assertEquals("TestUser", temp);
	}

	@Test
	public void NewOrder() {
		AppModel.setNewOrder(true);
		boolean b = AppModel.isNewOrder();
		assertEquals(true, b);
	}

}
