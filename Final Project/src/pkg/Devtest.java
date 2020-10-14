/**
 * 
 */
package pkg;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

/**
 * @author user
 *
 */
public class Devtest {

	/**
	 * 
	 */
	public Devtest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JParser jp = new JParser();

		Order o2 = new Order();

		String[] temp2 = {"se2ats", "ro2of"};
		o2.setId(21);
		o2.setName("M2e");
		o2.setPrice(222220000);
		o2.setTrim("Package2");
		o2.setOptions(temp2);

		Order o = new Order();
		//String[] temp = new String[2];
		String[] temp = {"seats", "roof"};
		o.setId(1);
		o.setName("Me");
		o.setPrice(20000);
		o.setTrim("Package1");
		o.setOptions(temp);
		
		JSONHolder jh = new JSONHolder(1);
		jh.add(o2);
		jh.add(o);
jp.save(jh);





	//	jp.CreateOrderArray();

	}

	//FileIO fio = new FileIO("C://Users//user//Desktop//database.xml");
	//	fio.Createfile("C://Users//user//Desktop//AAA.txt");
	//	fio.saveToXML("James", "Title", "Dealer");
	//	fio.saveToXML("Customers","Customer","Name", "Sadie");
	//fio.addElement("Customers", "Customer", "Name", "Guy");
	//fio.addElement("Customers", "Customer", "Name", "Ralph");
	//	fio.addElement("Employee", "Name", "Johnny");
	//	fio.addElement("people", "Name", "Dad");
	//	fio.saveToXML_stock();
	//	fio.demoReadXML("Status");
	//	fio.readXML_stock();
	//	fio.save3();
	//	fio.read3();
	//	fio.updateNode();
	//	fio.updateElementValue("Customer", "Name", "Sadie", "Dad");


}
