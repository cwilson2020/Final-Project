package pkg;

public class OptionArray {

	Option array[];
	int index = 0;
	
	public OptionArray(int size) {
		super();
		array = new Option[size];
	}


	public void add(Option person) {
		array[index++] = person;
	}
	
	public Option[] getPeople(){
		return array;
	}
}
