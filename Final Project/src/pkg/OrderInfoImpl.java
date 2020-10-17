package pkg;

public class OrderInfoImpl  implements OrderInfo{

	public OrderInfoImpl() {
		
		
	}

	
	private Order FetchOrder() {
	return AppModel.getOrder();
	}


	@Override
	public String getStatus() {
		return FetchOrder().getStatus();
		
	}



	@Override
	public String setstatus(String Position, String newState) {
		FetchOrder().setStatus(newState);
		return "Order State Changed";
	}

}
