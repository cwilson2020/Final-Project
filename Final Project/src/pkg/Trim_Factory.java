package pkg;

public class Trim_Factory {
	
	Trim_Factory(){}
	

	public Trim Trim (int t)
	{
		Trim temp = null;

		switch(t) {

		case 1: temp = new Trim_Value();
		break;

		case 2: temp = new Trim_Common_Options();
		break;

		case 3: temp = new Trim_Extreme();
		break; 

		default: temp = new Trim_Value();
		
		}
return temp;
	}
}
