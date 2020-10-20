package pkg;

public class OrderStateBase {




	private OrderActions fulfilled;
	private OrderActions canceled;
	private OrderActions submitted;
	private OrderActions editing;



	private OrderActions orderState;
	String state;
	public OrderStateBase() {
		canceled = new CancelledOrder(this);
		submitted = new SubmittedOrder(this);
		fulfilled = new FulfilledOrder(this);
		editing = new  EditingOrder(this);

		if(AppModel.getOrder() == null)		
			state = "Editing";
		else 
			state = AppModel.getOrder().getStatus();

		switch(state) {
		case "canceled":
			orderState = canceled;
			break;
		case "Editing":
			orderState = editing;
			break;
		case "Submitted":
			orderState = submitted;
			break;
		case "fulfilled":
			orderState = fulfilled;
			break;
		}

		//   orderState = 
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





