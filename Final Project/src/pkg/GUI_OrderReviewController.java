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


		OptionIter iter = new OptionIter(helperFunctions.buildFactoryOptions().getOption());

		switch(trim) {
		case "Value":
			list="";
			iter = new OptionIter(helperFunctions.buildFactoryOptions().getOption());
			while (iter.hasNext()){
				list = list + "-" +iter.next().getName() +"\n";			
			}
			for(String s : AppModel.getOrder().getOptions())
				list = list + " " +s;		
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

		ta.setText(list);
	}

	public void submit() {
		
		String user;
		String status;
		OrderInfo oi = new OrderProxy();
		user="Dealer";
		else user="Customer";
		
		if(neworder.isSelected())
			status = "Open";
		else
			status = AppModel.getOrder().getStatus();				
		oi.setstatus(user, status);

		JParser.save(AppModel.getJh(), AppModel.getFile().getAbsolutePath());

		System.out.println("Submitted");


		lblmsg.setText("Submitting Order  Please wait");



		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(5000);
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

	public void BackButtom() {

		Pane pPane;	
Stage stage =  (Stage)gp.getScene().getWindow();	
			stage.close();
			
			
			AnchorPane aPane;
			try {
				aPane = (AnchorPane)FXMLLoader.load(getClass().getResource("Specifics_Entry.fxml"));
			
			Scene scene = new Scene(aPane,800,700);
			//	scene = new Scene(aPane,400,400);
			//	scene = new Scene(aPane,800,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			

		/*		
			pPane = (Pane)FXMLLoader.load(getClass().getResource("ValuePackageConfigurator.fxml"));

			 scene = new Scene(pPane,800,700);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage = (Stage)pPane.getScene().getWindow();
			stage.setTitle("Value Package Option Menu");

			stage.setScene(scene);

			stage.show();
*/
		}
	


}
