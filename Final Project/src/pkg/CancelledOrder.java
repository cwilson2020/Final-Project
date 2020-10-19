package pkg;

public class CancelledOrder implements OrderActions {

	OrderStateBase osb;
	
	
	
	public CancelledOrder(OrderStateBase losb) {		
		this.osb = losb;
	}

	

	@Override
	public String cancelOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order has already been cancelled");
		return "Order has already been cancelled";
	}


	@Override
	public String fulfillOrder() {
		// TODO Auto-generated method stub
			System.out.println("A canceled order can not be fulfilled");			
			return "A canceled order can not be fulfilled";
	}



	@Override
	public String submitOrder() {
				System.out.println("Order has been canceled therefore can not be submitted.");		
				return "Order has been canceled therefore can not be submitted.";
	}



	@Override
	public String editOrder() {
		osb.setOrderState(osb.getEditOrder());
		return "OK" ;
		
	}




}
