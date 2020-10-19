package pkg;

public class EditingOrder implements OrderActions {

	OrderStateBase osb;



	public EditingOrder(OrderStateBase losb) {

		this.osb = losb;

	}



	@Override
	public String cancelOrder() {	
		osb.setOrderState(osb.getCancelled());
	return "OK";		
	}



	@Override
	public String  fulfillOrder() {
		System.out.println("Order will need to submitted first");			
		return "Order will need to submitted first";
	}



	@Override
	public String submitOrder() {
		osb.setOrderState(osb.getSubmitted());
		return "OK";
	}



	@Override
	public String editOrder() {	
			System.out.println("Order open for editing");
			return  "Order open for editing";
	}



}
