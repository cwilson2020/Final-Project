package pkg;



import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI_Main_Controller {

	@FXML TextField tfName;
	@FXML private GridPane gPane;
	
	public GUI_Main_Controller() {

	}



	public void onLoad() {

	}

	public void buttonPress() {

		String s = tfName.getText();
		System.out.println(s);
		FileIO fio = new FileIO("C://Users//user//Desktop//database.xml");
		
		XML_IO x = new XML_IO();
		//x.launch();
		x.update();
		
//	Scene scene = new Scene(gPane,400,400);
	//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage = (Stage)gPane.getScene().getWindow();
		//stage.setScene(scene);
		stage.close();

	}
	
	
	
}
