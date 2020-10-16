package pkg;

import java.io.File;

public class AppModel {

	private static JSONHolder jh;
	private static Order order;
	private static File file;

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



}
