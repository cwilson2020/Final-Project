/**
 * 
 */
package pkg;

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
		FileIO fio = new FileIO("C://Users//user//Desktop//database.xml");
	//	fio.Createfile("C://Users//user//Desktop//AAA.txt");
	//	fio.saveToXML("James", "Title", "Dealer");
	fio.saveToXML("Customers","Customer","Name", "Sadie");
	fio.addElement("Customers", "Customer", "Name", "Guy");
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

}
