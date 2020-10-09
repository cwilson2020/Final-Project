package pkg;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XML_IO {


	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder;
	public XML_IO() {		
	}



	public void launch() {

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// add elements to Document
			Element rootElement = doc.createElement("Users");
			// append root element to document
			doc.appendChild(rootElement);

			// append first child element to root element
			//	rootElement.appendChild(createUserElement(doc, "1", "Ramesh", "Fadatare", "28", "Male"));

			// append second child
			//rootElement.appendChild(createUserElement(doc, "2", "John", "Cena", "45", "Male"));

			// append third child
			//rootElement.appendChild(createUserElement(doc, "3", "Tom", "Cruise", "40", "Male"));

			rootElement.appendChild(createUserElement(doc, "5", "Charlie", "Wilson Cruise", "95", "Male"));

			// for output to file, console
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// for pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			// write to console or file
			//  StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("C://Users//user//Desktop//database.xml"));

			// write data
			//    transformer.transform(source, console);
			transformer.transform(source, file);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// utility method to create text node
	private static Node createUserElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

	private static Node createUserElement(Document doc, String id, String firstName, String lastName, String age,
			String gender) {
		Element user = doc.createElement("User");

		// set id attribute
		user.setAttribute("id", id);

		// create firstName element
		user.appendChild(createUserElements(doc, user, "firstName", firstName));

		// create lastName element
		user.appendChild(createUserElements(doc, user, "lastName", lastName));

		// create age element
		user.appendChild(createUserElements(doc, user, "age", age));

		// create gender element
		user.appendChild(createUserElements(doc, user, "gender", gender));

		return user;
	}

	
	public void getEntry() {
	       DocumentBuilder dBuilder;
	     
	            try {
					dBuilder = dbFactory.newDocumentBuilder();
				

	            // parse xml file and load into document
	            Document doc = dBuilder.parse("C://Users//user//Desktop//database.xml");
	           	            
	            
		
		 NodeList users = doc.getElementsByTagName("User");
	        Element user = null;
	        // loop for each user
	        for (int i = 0; i < users.getLength(); i++) {
	            user = (Element) users.item(i);
	            Node name = user.getElementsByTagName("firstName").item(0).getFirstChild();
	             Node lastName = user.getElementsByTagName("lastname").item(0).getFirstChild();
	            
	            name.setNodeValue("changedFirstName");
	            name.setNodeValue("changedLastName");
	        }
	   
	
	 } catch (ParserConfigurationException | SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}
	
	
		
	
	public void update() {
		String filePath = "C://Users//user//Desktop//database.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			// parse xml file and load into document
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();

			// update Element value
			updateElementValue(doc);

			// delete element
			//deleteElement(doc);

			// add new element
		//	addElement(doc);

			// write the updated document to file or console

			writeXMLFile(doc);

		}
		catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException | SAXException | IOException e1) {

			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

	private static void writeXMLFile(Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		doc.getDocumentElement().normalize();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("users_updated.xml"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
		System.out.println("XML file updated successfully");
	}

	/**
	 * Add a new element salary to user element.
	 * @param doc
	 */
	private static void addElement(Document doc) {
		NodeList users = doc.getElementsByTagName("User");
		Element emp = null;

		// loop for each user
		for (int i = 0; i < users.getLength(); i++) {
			emp = (Element) users.item(i);
			Element salaryElement = doc.createElement("salary");
			salaryElement.appendChild(doc.createTextNode("10000"));
			emp.appendChild(salaryElement);
		}
	}

	/**
	 * Delete gender element from User element
	 * @param doc
	 */
	private static void deleteElement(Document doc) {
		NodeList users = doc.getElementsByTagName("User");
		Element user = null;
		// loop for each user
		for (int i = 0; i < users.getLength(); i++) {
			user = (Element) users.item(i);
			Node genderNode = user.getElementsByTagName("gender").item(0);
			user.removeChild(genderNode);
		}

	}

	/**
	 * Update firstName element value to Upper case.
	 * @param doc
	 */
	private static void updateElementValue(Document doc) {
		NodeList users = doc.getElementsByTagName("User");
		Element user = null;
		// loop for each user
		for (int i = 0; i < users.getLength(); i++) {
			user = (Element) users.item(i);
			Node name = user.getElementsByTagName("firstName").item(0).getFirstChild();
			name.setNodeValue(name.getNodeValue().toUpperCase());
		}
	}
}


