package pkg;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI_Controller_Trim {
	@FXML private TextArea taValue;
	@FXML private TextArea taCommon;
	@FXML private TextArea taExtreme;
	@FXML private ToggleGroup trimToggleGroup;

	@FXML private AnchorPane aPane;
	AppModel appModel;
	Stage stage;



	public GUI_Controller_Trim() {

		System.out.println("GUI _Controllerstage TestTrim constructor");

	}


	@FXML
	public void initialize() {	

		System.out.println("POPULATE");
		//Stage stage = (Stage) aPane.getScene().getWindow();

		String list =  new String();
		OptionIter iter = new OptionIter(helperFunctions.buildFactoryOptions().getOption());
		while (iter.hasNext()){
			list = list + "-" +iter.next().getName() +"\n";
		}
		taValue.setText(list);

		list="";
		iter = new OptionIter(helperFunctions.buildCommonOptions().getOption());
		while (iter.hasNext()){
			list = list + "-" +iter.next().getName() +"\n";
		}
		taCommon.setText(list);

		list="";
		iter = new OptionIter(helperFunctions.buildExtremeOptions().getOption());
		while (iter.hasNext()){
			list = list + "-" +iter.next().getName() +"\n";
		}
		taExtreme.setText(list);
	}



	public void nextButtonAction() {
		System.out.println("GUI _Controllerstage TestTrim");

		Stage stage = (Stage) aPane.getScene().getWindow();
		RadioButton selection = (RadioButton) trimToggleGroup.getSelectedToggle();
		String whichButton = selection.getText();
		System.out.println(whichButton);

		Order order;


		switch(whichButton) {
		case "Value":
			System.out.println("Value Chosen");
			order = AppModel.getOrder();
			order.setTrim("Value");
			AppModel.setOrder(order);
			GUI_Launcher_ValueTrim vp = new GUI_Launcher_ValueTrim(stage);
			break;
		case "Common":
			System.out.println("Common Chosen");		
			order = AppModel.getOrder();
			order.setTrim("Common");
			AppModel.setOrder(order);
			//	GUI_Launcher_CommonTrim cp = new GUI_Launcher_ValueTrim(stage);
			break;
		case "Extreme":
			System.out.println("Extreme Chosen");	
			order = AppModel.getOrder();
			order.setTrim("Extreme");
			AppModel.setOrder(order);
			//	GUI_Launcher_ExtremeTrim ep = new GUI_Launcher_ValueTrim(stage);
			break;

		default: System.out.println("No Selection Detected");
		break;
		}


	}

}
