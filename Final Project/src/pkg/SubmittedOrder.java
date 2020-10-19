package pkg;

public class SubmittedOrder implements OrderActions {

	OrderStateBase osb;



	public SubmittedOrder(OrderStateBase losb) {

		this.osb = losb;
	}


	@Override
	public String cancelOrder() {
		System.out.println("Order moving from submitted state to cancelled");
		osb.setOrderState(osb.getCancelled());
		return "OK";
	}



	@Override
	public String fulfillOrder() {
		System.out.println("Order Fulfilled");
		osb.setOrderState(osb.getFulfilled());	
		return "OK";
	}



	@Override
	public String submitOrder() {
		System.out.println("Order Already Submitted");
		return "Order Already Submitted";		
	}



	@Override
	public String editOrder() {
		System.out.println("Unsubmitting the order for editing");
		osb.setOrderState(osb.getEditOrder());		
		return "OK";
	}


}
