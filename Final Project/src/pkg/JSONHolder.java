package pkg;

public class JSONHolder {

	Order array[];
	int index = 0;

	public JSONHolder(int size) {
		super();
		array = new Order[size];
	}


	public void add( Order order) {
		if(index >= array.length) {
			stretchArray();
		}

		array[index++] = order;
	}

	public Order[] getOrder(){
		return array;
	}

	private void stretchArray() {
		Order[] tempArray = new Order[array.length+1];
		for(int i =0; i <array.length; i++) {
			tempArray[i] = array[i];
		}

		array = new Order[tempArray.length];

		System.arraycopy(tempArray,0, array, 0, tempArray.length);				

	}
	public int getOrderIndexByID(int id) {
		boolean found = false;
		int ret = -1; 
		int i =0;
		while(i <array.length && !found) {
			if(array[i].getId() == id) {
				found = true;
				ret =i;
			}
			i++;
		}
		return ret;
		
	}

	public void update (int index, Order order) {
		array[index] = order;
	}

	public Order getByIndex(int index) {
		return array[index];
	}
}
