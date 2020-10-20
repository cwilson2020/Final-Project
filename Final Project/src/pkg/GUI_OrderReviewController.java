package pkg;

import java.io.IOException;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI_OrderReviewController {

	@FXML private TextArea ta;
	@FXML private GridPane gp;
	@FXML private Label lblmsg;
	@FXML private Button btnsubmit;
	@FXML private Button btnclose;


	public GUI_OrderReviewController() {
		// TODO Auto-generated constructor stub
	}


	@FXML
	public void initialize() {	
		System.out.println("initialized");

		String list =  new String();
		String trim = AppModel.getOrder().getTrim();

		if(AppModel.getCurrent_user().equals("Dealer")) {
			btnsubmit.setText("Fulfill");
		}

		OptionIter iter = new OptionIter(helperFunctions.buildFactoryOptions().getOption());

		switch(trim) {
		case "Value":
			list="";
			iter = new OptionIter(helperFunctions.buildFactoryOptions().getOption());
			while (iter.hasNext()){
				list = list + "-" +iter.next().getName() +"\n";			
			}
			list = list + "\nOptions: \n-----------------------";
			for(String s : AppModel.getOrder().getOptions())
				list = list + "\n" +s;	
			break;
		case "Common":
			System.out.println("Common Chosen");
			list="";
			iter = new OptionIter(helperFunctions.buildCommonOptions().getOption());
			while (iter.hasNext()){
				list = list + "-" +iter.next().getName() +"\n";			
			}
			for(String s : AppModel.getOrder().getOptions())
				list = list + " " +s;		
			break;
		case "Extreme":
			System.out.println("Extreme Chosen");
			list="";
			iter = new OptionIter(helperFunctions.buildExtremeOptions().getOption());
			while (iter.hasNext()){
				list = list + "-" +iter.next().getName() +"\n";			
			}
			for(String s : AppModel.getOrder().getOptions())
				list = list + " " +s;		
			break;

		default: System.out.println("No Selection Detected");
		break;
		}


		list+="\nTrim Price: $" + AppModel.getOrder().getPrice() +"\n"
				+ "Option Total: $"+ AppModel.getOrder().getOption_price()+"\n"
				+ "Total Price: $" + String.valueOf(AppModel.getOrder().getPrice() + AppModel.getOrder().getOption_price());
		ta.setText(list);
	}



	public void submit() {

	if(AppModel.getCurrent_user().equals("Dealer"))
		dealersubmit();
	else
		customersubmit();
	}
	
	private void dealersubmit() {

		String user;
		String status;
		OrderInfo oi = new OrderProxy();
		user=AppModel.getCurrent_user();


		//status = AppModel.getOrder().getStatus();				
		oi.setstatus(user, "Fulfilled");

		int id =AppModel.getOrder().getId();
		int index = AppModel.getJh().getOrderIndexByID(id);

		if((index !=-1)) {
			AppModel.getJh().update(index, AppModel.getOrder());			
		}

		JParser.save(AppModel.getJh(), AppModel.getFile().getAbsolutePath());

		System.out.println("Fulfilled");

		btnsubmit.setVisible(false);
		lblmsg.setText("Fulfilling Order  Please wait.....");



		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				return null;
			}
		};
		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				btnsubmit.setVisible(false);
				lblmsg.setVisible(false);
				btnclose.setVisible(true);
				btnclose.setDisable(false);

			}
		});
		new Thread(sleeper).start();
	}


	private void customersubmit() {		

		String user;
		String status;
		OrderInfo oi = new OrderProxy();
		user=AppModel.getCurrent_user();


		//status = AppModel.getOrder().getStatus();				
		oi.setstatus(user, "Submitted");

		int id =AppModel.getOrder().getId();
		int index = AppModel.getJh().getOrderIndexByID(id);

		if((index !=-1)) {
			AppModel.getJh().update(index, AppModel.getOrder());			
		}

		JParser.save(AppModel.getJh(), AppModel.getFile().getAbsolutePath());

		System.out.println("Submitted");

		btnsubmit.setVisible(false);
		lblmsg.setText("Submitting Order  Please wait.....");



		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				return null;
			}
		};
		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				btnsubmit.setVisible(false);
				lblmsg.setVisible(false);
				btnclose.setVisible(true);
				btnclose.setDisable(false);

			}
		});
		new Thread(sleeper).start();
	}

	public void close() {
		Stage stage = (Stage)gp.getScene().getWindow();
		stage.close();
	}

	public void BackButton() {
		AppModel.getOrder().setStatus("Editing");
		Pane pPane;	
		Stage stage =  (Stage)gp.getScene().getWindow();	
		stage.close();


		AnchorPane aPane;
		try {
			aPane = (AnchorPane)FXMLLoader.load(getClass().getResource("Specifics_Entry.fxml"));

			Scene scene = new Scene(aPane,800,700);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			


	}



}
