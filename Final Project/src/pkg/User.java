package pkg;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class User {

 
    private String name;
    private String email;
private String roles;
    Order order;

    public User() {
    }

    public User(int id, String name, String email, String[] roles, boolean admin) {
       
  
    }
    
}

   