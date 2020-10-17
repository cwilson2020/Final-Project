package pkg;

public class OrderProxy implements OrderInfo {


	private static OrderInfo orderInfo;


	public OrderProxy() {

	}



	@Override
	public String getStatus() {
		String ret = new String("");
		if(orderInfo == null) {
			orderInfo = new OrderInfoImpl();
			System.out.println("Creating new order instance");
			ret = "Creating new order instance";
		}
		orderInfo.getStatus();	

		return ret;
	}

	@Override
	public String setstatus(String userType, String newState) {
		Order order = AppModel.getOrder();

		String ret;

		if(orderInfo == null) {
			orderInfo = new OrderInfoImpl();
			System.out.println("Creating new order instance");
			ret = "Creating new order instance";
		}


		if(userType.equals("Dealer") && newState.equals("Open")) {
			orderInfo.setstatus(userType, "A dealer can't reopen this order");	
			ret = "No state change a dealer can't issue a reorder";
		}
		else if(userType.equals("Customer") && newState.equals("Fulfill")) {
			ret = "No state change a customer can't fulfill an order";

			orderInfo.setstatus(userType, "No state change a customer can't fulfill an order");	
		}
		else {
			ret = orderInfo.setstatus(userType, newState);	
			order.setStatus(newState);
		}

		return ret;


	}
}
