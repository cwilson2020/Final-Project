package pkg;

public class FulfilledOrder implements OrderActions {

	OrderStateBase osb;



	public FulfilledOrder(OrderStateBase losb) {

		this.osb = losb;

	}



	@Override
	public String cancelOrder() {
		System.out.println("Order has been fulfilled and can not be cancelled.");
	return "Order has been fulfilled and can not be cancelled.";
		
	}



	@Override
	public String  fulfillOrder() {
		System.out.println("Order already fulfilled");			
		return "Order already fulfilled";
	}



	@Override
	public String submitOrder() {
		System.out.println("Order Already Submitted and fulfilled");
		return "Order Already Submitted and fulfilled";
	}



	@Override
	public String editOrder() {	
			System.out.println("Order Already Submitted and fulfilled");
			return "Order Already Submitted and fulfilled";
	}



}
