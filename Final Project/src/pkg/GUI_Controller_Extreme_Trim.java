package pkg;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI_Controller_Extreme_Trim {
	@FXML private TextArea taValue;
	@FXML private TextArea taCommon;
	//	@FXML private TextArea taExtreme;
	@FXML private TextArea taOptions;
	@FXML private Label lbl;


	@FXML private Pane pPane;	
	@FXML private CheckBox cb1;
	@FXML private CheckBox cb2;
	@FXML private CheckBox cb3;
	@FXML private CheckBox cb4;
	@FXML private CheckBox cb5;
	@FXML private CheckBox cb6;

	@FXML private AnchorPane aPane;

	Stage stage;
	private int optionTotal;
	ArrayList<String> al;
	private Trim trim;

	public GUI_Controller_Extreme_Trim() {

		System.out.println("GUI _Controller Common Trim constructor");
	}

	public void onCheckbox() {
		optionTotal = 0;
		al = new  ArrayList<String>();
		String list =  new String();
		OptionIter iter = new OptionIter(helperFunctions.buildExtremeOptions().getOption());
		while (iter.hasNext()){
			list = list + "-" +iter.next().getName() +"\n";
		}
		list = list +"\n";

		if (cb1.isSelected())
		{
			list = list + cb1.getText()+"\n";
			al.add( cb1.getText());
			optionTotal += 2500;			
		}

		if (cb2.isSelected())
		{
			list = list +cb2.getText()+"\n";
			al.add( cb2.getText());
			optionTotal += 1800;
		}
		if (cb3.isSelected())
		{
			list = list + cb3.getText()+"\n";
			al.add( cb3.getText());
			optionTotal += 700;
		}		
		if (cb4.isSelected())
		{
			list = list + cb4.getText()+"\n";
			al.add( cb4.getText());
			optionTotal += 1200;
		}	
		if (cb5.isSelected())
		{
			list = list + cb5.getText()+"\n";
			al.add( cb5.getText());
			optionTotal += 500;
		}
		if (cb6.isSelected())
		{
			list = list + cb6.getText()+"\n";
			al.add( cb6.getText());
			optionTotal += 1000;
		}
		list+="-----------------------\n"
				+"Trim Price:" + String.valueOf(new Value_Type().getPrice()) +"\n"
				+ "Option Total: "+ String.valueOf(optionTotal) +"\n"
				+ "Total Price: " + String.valueOf(optionTotal + new Value_Type().getPrice());
		taOptions.setText(list);

	}


	@FXML
	public void initialize() {	
		System.out.println("initialized Value trim ");
		cb1.setText("Turbo High Output Engine $2500");
		cb2.setText("20 Inch chrome upgrade $1800 ");
		cb3.setText("Racing Seats Cooled & Heated $700");
		cb4.setText("Premium Infotainment System $1200");
		cb5.setText("Black Appearance Package $500");
		cb6.setText("360 Surround Camera $1000");

		String list =  new String();
		al = new  ArrayList<String> ();
		OptionIter iter = new OptionIter(helperFunctions.buildExtremeOptions().getOption());
		while (iter.hasNext()){
			list = list + "-" +iter.next().getName() +"\n";
		}


		String[] options = AppModel.getOrder().getOptions();
		if ((options != null) && (options.length>0)){
			if (helperFunctions.SearchArray(options, cb1.getText()) !=-1) {
				cb1.setSelected(true);
				list = list + "\n" +cb1.getText();
				al.add( cb1.getText());
				optionTotal += 2500;
			}

			if (helperFunctions.SearchArray(options, cb2.getText()) !=-1) {
				cb2.setSelected(true);
				list = list + "\n" +cb2.getText();
				al.add( cb2.getText());
				optionTotal += 1800;
			}

			if (helperFunctions.SearchArray(options, cb3.getText()) !=-1) {
				cb3.setSelected(true);
				list = list + "\n" +cb3.getText();
				al.add( cb3.getText());
				optionTotal += 700;
			}
			if (helperFunctions.SearchArray(options, cb4.getText()) !=-1) {
				cb4.setSelected(true);
				list = list + "\n" +cb4.getText();
				al.add( cb4.getText());
				optionTotal += 1200;
			}
			if (helperFunctions.SearchArray(options, cb5.getText()) !=-1) {
				cb5.setSelected(true);
				list = list + "\n" +cb5.getText();
				al.add( cb5.getText());
				optionTotal += 500;
			}	
			if (helperFunctions.SearchArray(options, cb6.getText()) !=-1) {
				cb6.setSelected(true);
				list = list + "\n" +cb6.getText();
				al.add( cb6.getText());
				optionTotal += 1000;
			}
		}

		list+="\n-----------------------\n"
				+"Trim Price:" + String.valueOf(new Value_Type().getPrice()) +"\n"
				+ "Option Total: "+ String.valueOf(optionTotal) +"\n"
				+ "Total Price: " + String.valueOf(optionTotal + new Value_Type().getPrice());

		taOptions.setText(list);
	}


	public void nextButtonAction() {
		Order order = AppModel.getOrder();
		order.setOption_price(optionTotal);
		order.setStatus("Editing");
		order.setTrim("Extreme");
		int i = 0;
		String[] options = new String[al.size()];
		for (String s : al) {
			options[i++] = s;
		}

		order.setOptions(options);
		//AppModel.setOrder(order);
		JSONHolder jh = AppModel.getJh();
		if(!AppModel.isNewOrder()) {
			int index = jh.getOrderIndexByID(order.getId());		
			jh.update(index, order);
		}
		else {
			//jh.add(order);
			AppModel.setNewOrder(false);
		}

		AppModel.setJh(jh);		
		AppModel.setOrder(order);		
		JParser.save(jh, AppModel.getFile().getAbsolutePath());

		System.out.println("Next Button Pushed");
		Stage stage = (Stage)pPane.getScene().getWindow();
		stage.close();

		try {
			GridPane gPane = (GridPane)FXMLLoader.load(getClass().getResource("OrderReview.fxml"));

			Scene scene = new Scene(gPane,800,700);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
