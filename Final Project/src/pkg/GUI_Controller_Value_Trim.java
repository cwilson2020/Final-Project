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

public class GUI_Controller_Value_Trim {
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

	ArrayList<String> al;

	public GUI_Controller_Value_Trim() {
		ArrayList<String> al = new  ArrayList<String> ();
		System.out.println("GUI _Controllerstage TestTrim constructor");


	}

	public void onCheckbox() {
		String list =  new String();
		OptionIter iter = new OptionIter(helperFunctions.buildFactoryOptions().getOption());
		while (iter.hasNext()){
			list = list + "-" +iter.next().getName() +"\n";
		}
		list = list +"\n";
		al = new  ArrayList<String> ();
		if (cb1.isSelected())
		{
			list = list + cb1.getText()+"\n";
			al.add( cb1.getText());
		}

		if (cb2.isSelected())
		{
			list = list +cb2.getText()+"\n";
			al.add( cb2.getText());
		}
		if (cb3.isSelected())
		{
			list = list + cb3.getText()+"\n";
			al.add( cb3.getText());
		}		
		if (cb4.isSelected())
		{
			list = list + cb4.getText()+"\n";
			al.add( cb4.getText());
		}	
		if (cb5.isSelected())
		{
			list = list + cb5.getText()+"\n";
			al.add( cb5.getText());
		}

		taOptions.setText(list);
	}


	@FXML
	public void initialize() {	
		System.out.println("initialized");
		cb1.setText("Race Engine Upgrade");
		cb2.setText("Wheel Upgrade ");
		cb3.setText("Leather Seats");
		cb4.setVisible(false);
		cb5.setVisible(false);
		cb6.setVisible(false);
	
		String list =  new String();
		OptionIter iter = new OptionIter(helperFunctions.buildFactoryOptions().getOption());
		while (iter.hasNext()){
			list = list + "-" +iter.next().getName() +"\n";
		}
		

		String[] options = AppModel.getOrder().getOptions();
		if (helperFunctions.SearchArray(options, cb1.getText()) !=-1) {
				cb1.setSelected(true);
		list = list + "\n" +cb1.getText();
		}
		
		if (helperFunctions.SearchArray(options, cb2.getText()) !=-1) {
			cb2.setSelected(true);
	list = list + "\n" +cb1.getText();
	}
		
		if (helperFunctions.SearchArray(options, cb3.getText()) !=-1) {
			cb3.setSelected(true);
	list = list + "\n" +cb1.getText();
	}
		
		
		
		taOptions.setText(list);

	}


	public void nextButtonAction() {
		Order order = AppModel.getOrder();
		int i = 0;
		String[] options = new String[al.size()];
		for (String s : al) {
			options[i++] = s;
		}
		order.setOptions(options);
		JSONHolder jh = AppModel.getJh();
		int index = jh.getOrderIndexByID(order.getId());
		jh.update(index, order);


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
