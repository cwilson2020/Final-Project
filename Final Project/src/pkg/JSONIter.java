package pkg;
import java.util.Iterator;

public class JSONIter implements Iterator<Order>{

	private Order orderArray[];
	private int index = 0;

	public JSONIter(Order[] orders) {
		orderArray = orders;
	}

	@Override
	public boolean hasNext() {
		boolean ret = true;
		
			 if (index >= orderArray.length)
				ret = false;
		
		
		else if (orderArray[index] == null)
			ret = false;

	return ret;
	}

	@Override
	public Order next() {
		return orderArray[index++];
	}

}
