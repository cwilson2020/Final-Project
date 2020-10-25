package pkg;

import java.io.File;

public class AppModel {

	private static JSONHolder jh;
	private static Order order;
	private static File file;
	private static String current_user;
	private static boolean isNewOrder;

	public AppModel() {
		// TODO Auto-generated constructor stub
	}
	
	public AppModel(JSONHolder ljh, Order lorder, File lfile) {
		this.jh = ljh;
		this.order = lorder;
		this. file =lfile;
	}

	public static JSONHolder getJh() {
		return jh;
	}
	public static void setJh(JSONHolder jh) {
		AppModel.jh = jh;
	}
	public static Order getOrder() {
		return order;
	}
	public static void setOrder(Order order) {
		AppModel.order = order;
	}
	public static File getFile() {
		return file;
	}
	public static void setFile(File file) {
		AppModel.file = file;
	}
	public static String getCurrent_user() {
		return current_user;
	}
	public static void setCurrent_user(String current_user) {
		AppModel.current_user = current_user;
	}
	public static boolean isNewOrder() {
		return isNewOrder;
	}
	public static void setNewOrder(boolean isNewOrder) {
		AppModel.isNewOrder = isNewOrder;
	}



}
