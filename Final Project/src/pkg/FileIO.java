package pkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileIO {

	private String role1 = "r1";
	private String role2 = "r2";
	private String role3 = "r3";
	private String role4 = "r4";
	private ArrayList<String> rolev;
	private String location;

	public FileIO(String location) {
		this.location = location; 
	}


	public boolean fileExists(String path) {
		File f = new File(path);

		if(f.exists() && !f.isDirectory())
			return true;
		else 
			return false;
	}

	public static boolean Createfile(String path) {
		boolean result = false;
		try {
			File myObj = new File(path);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				result = true;
			} else {
				System.out.println("File already exists.");
				result = false;
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			result = false;
		}
		return result;
	}


	public void saveToXML(String docRoot, String root, String key, String value) {
		Document doc;
		Element e = null;

		// instance of a DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// use factory to get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// create instance of DOM
			doc = db.newDocument();

			// create the root element
			Element rootEle = doc.createElement(docRoot);
			doc.appendChild(rootEle);
			Element child = doc.createElement(root);
			rootEle.appendChild(child);
			Element child1 = doc.createElement(key);
			child.appendChild(child1);
			child1.appendChild(doc.createTextNode(value));

			/*
			// create data elements and place them under root
			e = doc.createElement(root);
			e.appendChild(key);
			e.appendChild(doc.createTextNode(value));
			rootEle.appendChild(e);



			doc.appendChild(rootEle);
			 */
			try {
				Transformer tr = TransformerFactory.newInstance().newTransformer();
				tr.setOutputProperty(OutputKeys.INDENT, "yes");
				tr.setOutputProperty(OutputKeys.METHOD, "xml");
				tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				//	tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "ppp");
				tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

				// send DOM to file
				tr.transform(new DOMSource(doc), 
						new StreamResult(new FileOutputStream(location)));

			} catch (TransformerException te) {
				System.out.println(te.getMessage());
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		} catch (ParserConfigurationException pce) {
			System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
		}
	}










	public boolean readXML(String key) {
		rolev = new ArrayList<String>();
		String entry;
		Document dom;
		// Make an  instance of the DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// use the factory to take an instance of the document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// parse using the builder to get the DOM mapping of the    
			// XML file
			dom = db.parse(location);

			Element doc = dom.getDocumentElement();

			entry = getTextValue(role1, doc, "role1");
			if (role1 != null) {
				if (!role1.isEmpty())
					rolev.add(role1);
			}

			return true;

		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		} catch (SAXException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		return false;
	}

	private String getTextValue(String def, Element doc, String tag) {
		String value = def;
		NodeList nl;
		nl = doc.getElementsByTagName(tag);
		if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
			value = nl.item(0).getFirstChild().getNodeValue();
		}
		return value;
	}




	public boolean demoReadXML(String key) {
		rolev = new ArrayList<String>();
		String entry;
		String root = "James";
		Document dom;
		// Make an  instance of the DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// use the factory to take an instance of the document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// parse using the builder to get the DOM mapping of the    
			// XML file
			dom = db.parse(location);

			Element doc = dom.getDocumentElement();

			entry = getTextValue(root, doc, key);
			if (root != null) {
				if (!root.isEmpty())
					rolev.add(root);
			}
			System.out.println(entry);

			return true;

		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		} catch (SAXException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		return false;
	}



	public boolean readXML_stock() {
		rolev = new ArrayList<String>();
		Document dom;
		// Make an  instance of the DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// use the factory to take an instance of the document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// parse using the builder to get the DOM mapping of the    
			// XML file
			dom = db.parse(location);

			Element doc = dom.getDocumentElement();

			role1 = getTextValue(role1, doc, "role1");
			if (role1 != null) {
				if (!role1.isEmpty())
					rolev.add(role1);
			}
			role2 = getTextValue(role2, doc, "role2");
			if (role2 != null) {
				if (!role2.isEmpty())
					rolev.add(role2);
			}
			role3 = getTextValue(role3, doc, "role3");
			if (role3 != null) {
				if (!role3.isEmpty())
					rolev.add(role3);
			}
			role4 = getTextValue(role4, doc, "role4");
			if ( role4 != null) {
				if (!role4.isEmpty())
					rolev.add(role4);
			}
			return true;

		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		} catch (SAXException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		return false;
	}


	public void saveToXML_stock() {
		Document dom;
		Element e = null;

		// instance of a DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// use factory to get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// create instance of DOM
			dom = db.newDocument();

			// create the root element
			Element rootEle = dom.createElement("roles");

			// create data elements and place them under root
			e = dom.createElement("role1");
			e.appendChild(dom.createTextNode(role1));
			rootEle.appendChild(e);

			e = dom.createElement("role2");
			e.appendChild(dom.createTextNode(role2));
			rootEle.appendChild(e);

			e = dom.createElement("role3");
			e.appendChild(dom.createTextNode(role3));
			rootEle.appendChild(e);

			e = dom.createElement("role4");
			e.appendChild(dom.createTextNode(role4));
			rootEle.appendChild(e);

			dom.appendChild(rootEle);

			try {
				Transformer tr = TransformerFactory.newInstance().newTransformer();
				tr.setOutputProperty(OutputKeys.INDENT, "yes");
				tr.setOutputProperty(OutputKeys.METHOD, "xml");
				tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "ppp");
				tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

				// send DOM to file
				tr.transform(new DOMSource(dom), 
						new StreamResult(new FileOutputStream(location)));

			} catch (TransformerException te) {
				System.out.println(te.getMessage());
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		} catch (ParserConfigurationException pce) {
			System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
		}
	}

	public void addElement(String docRoot,String root, String newTag, String value) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		Document doc = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			doc = docBuilder.parse(location);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 NodeList users = doc.getElementsByTagName("Customers");
	        Element emp = null;

	        // loop for each user
	        for (int i = 0; i < users.getLength(); i++) {
	            emp = (Element) users.item(i);
	            
	            Element salaryElement = doc.createElement("Customer");
	              Element child1 = doc.createElement("Name");
	              child1.appendChild(doc.createTextNode("Helen"));
	            Element child2 = doc.createElement("Item1");
	            child2.appendChild(doc.createTextNode("SunRoof"));
	         //    child1.appendChild(child2);
	            //salaryElement.appendChild(doc.createTextNode("10000"));
	              salaryElement.appendChild(child1);
	              salaryElement.appendChild(child2);
	            emp.appendChild(salaryElement);
	        } 
	      
		try {
			writeXMLFile(doc);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
/*
	public void read3() {
		try {
			// parse XML file to build DOM
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document dom = builder.parse(new File(location));

			// normalize XML structure
			dom.normalizeDocument();

			// get root element
			Element root = dom.getDocumentElement();

			// print attributes
			System.out.println("ID: " + root.getAttribute("id"));

			// print elements
			System.out.println("Name: " + root.getElementsByTagName("name").item(0).getTextContent());
			System.out.println("Email: " + root.getElementsByTagName("email").item(0).getTextContent());
			System.out.println("Phone: " + root.getElementsByTagName("role").item(0).getTextContent());
			System.out.println("Phone: " + root.getElementsByTagName("role").item(1).getTextContent());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
*/

/*
	public void updateNode() {

		try {
			String filepath = location;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node company = doc.getFirstChild();

			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();

			// Get the staff element by tag name directly
			//	Node person = doc.getElementsByTagName(" id").item(0);



			//	NamedNodeMap attr = person.getAttributes();
			//Node nodeAttr = attr.getNamedItem("name");
			Node name = doc.getElementsByTagName("name").item(0);
			//	nodeAttr.setTextContent("changed name");

			// append a new node to staff
			Element age = doc.createElement("age");
			age.appendChild(doc.createTextNode("97"));
			company.appendChild(age);

			// loop the staff child node
			//	NodeList list = person.getChildNodes();

			//	for (int i = 0; i < list.getLength(); i++) {

			//	Node node = list.item(i);

			// get the salary element, and update the value
			//	if ("salary".equals(node.getNodeName())) {
			//		node.setTextContent("2000000");
			//	}

			//remove firstname
			//	if ("firstname".equals(node.getNodeName())) {
			//		staff.removeChild(node);
			//}

			//}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

			System.out.println("Done");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}


	}*/



	public void updateElementValue(String rootTag, String tagToFind, String oldValue, String newValue) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		Document doc = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			doc = docBuilder.parse(location);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		NodeList users = doc.getElementsByTagName(rootTag);
		Element user = null;
		// loop for each user
		for (int i = 0; i < users.getLength(); i++) {
			user = (Element) users.item(i);
			// Node name = user.getElementsByTagName("firstName").item(0).getFirstChild();
			Node name = user.getElementsByTagName(tagToFind).item(0).getFirstChild();
			if(name.getNodeValue().equals(oldValue))
			name.setNodeValue(newValue);
			try {
				writeXMLFile(doc);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void writeXMLFile(Document doc) throws TransformerException {
		doc.getDocumentElement().normalize();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(location));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
		System.out.println("XML file updated successfully");
	}
}


