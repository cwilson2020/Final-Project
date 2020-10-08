package pkg;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI_Controller_Trim {
	@FXML TextArea taValue;
	@FXML private AnchorPane aPane;
	//@FXML Stage stage;
	Stage stage;

/*	public GUI_Controller_Trim(Stage stage) {
		this.stage = stage;

	}*/
	public GUI_Controller_Trim() {
		
		System.out.println("GUI _Controllerstage TestTrim constructor");
		
	}

	public void show() {


		//Stage stage = (Stage)aPane.getScene().getWindow();

		try {
			//AnchorPane aPane = (AnchorPane)FXMLLoader.load(getClass().getResource("Specifics_Entry.fxml"));
			//	stage = (Stage)aPane.getScene().getWindow();
			//	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(aPane,800,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);

			//	scene = new Scene(aPane,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();

			/*
			 * 	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.close();
			 */


		} catch(Exception e) {
			e.printStackTrace();
		}


	}

	public void testTrim() {
		System.out.println("GUI _Controllerstage TestTrim");
		
		Stage stage = (Stage) aPane.getScene().getWindow();
		taValue.setText("Option Features");
		
	/*	AnchorPane aPane = (AnchorPane)FXMLLoader.load(getClass().getResource("Specifics_Entry.fxml"));
		scene = new Scene(aPane,800,700);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show(); */
	//	stage.close();


	}

}
