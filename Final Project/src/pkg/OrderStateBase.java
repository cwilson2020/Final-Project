package pkg;

public class OrderStateBase {




	private OrderActions fulfilled;
	private OrderActions canceled;
	private OrderActions submitted;
	private OrderActions editing;



	private OrderActions orderState;

	public OrderStateBase() {
		canceled = new CancelledOrder(this);
		submitted = new SubmittedOrder(this);
		fulfilled = new FulfilledOrder(this);
		editing = new  EditingOrder(this);
	//orderState = 
	}



	void setOrderState (OrderActions state) {
		orderState =state;
	}



	public String cancelOrder() {
		return orderState.cancelOrder();
	}

	public String editOrder() {
		return orderState.editOrder();

	}
	public String fulfillOrder() {
		return orderState.fulfillOrder();

	}

	public String submitOrder() {
		return orderState.submitOrder();
	}


	// Get methods
	public OrderActions getFulfilled() {
		return fulfilled;
	}

	public OrderActions getCancelled() {
		return canceled;
	}

	public OrderActions getSubmitted() {
		return submitted;
	}
	public OrderActions getEditOrder() {
		return editing;
	}





}





