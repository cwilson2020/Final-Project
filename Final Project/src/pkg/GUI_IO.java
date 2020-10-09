package pkg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class GUI_IO {
	@FXML TextArea tb1;
	@FXML private BorderPane bpane;
	@FXML private AnchorPane aPane;


	public GUI_IO() {			

	}

	public void test(){
		System.out.println("Test Succesfull");	
		String s = tb1.getText();
		System.out.println(s);
	}

	public void setButton() {
		tb1.setText("This is a test of setting text in a textArea");	
		System.out.println("Text Imput called");	
	}


	public void close() {


		Stage stage = (Stage)bpane.getScene().getWindow();

		try {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.close();

	
			AnchorPane aPane = (AnchorPane)FXMLLoader.load(getClass().getResource("Specifics_Entry.fxml"));
			scene = new Scene(aPane,800,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
