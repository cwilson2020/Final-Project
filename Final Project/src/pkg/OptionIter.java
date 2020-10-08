package pkg;
import java.util.Iterator;

public class OptionIter implements Iterator<Option>{

	private Option spArray[];
	private int index = 0;

	public OptionIter(Option[] peopleList) {
		spArray = peopleList;
	}

	@Override
	public boolean hasNext() {
		boolean ret = true;
		
			 if (index >= spArray.length)
				ret = false;
		
		
		else if (spArray[index] == null)
			ret = false;

	return ret;
	}

	@Override
	public Option next() {
		return spArray[index++];
	}

}
