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
		//fio.saveToXML("James", "Title", "Dealer");
		//fio.readXML("Title");
	//	fio.saveToXML_stock();
	//	fio.readXML_stock();
	//	fio.save3();
	//	fio.read3();
		fio.updateNode();
	}

}
