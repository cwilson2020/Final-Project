package pkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class  GUI_Launcher_ExtremeTrim{

	@FXML private TextArea taValue;
	@FXML private TextArea taCommon;
	@FXML private TextArea taExtreme;
	@FXML private ToggleGroup trimToggleGroup;
	@FXML private Pane pPane;
	@FXML private Stage stage;
	@FXML private GridPane gPane;
	@FXML private CheckBox cb1;


	public GUI_Launcher_ExtremeTrim(Stage stage) {
		//this.fPane = fPane;
		this.stage = stage;

		try {
			pPane = (Pane)FXMLLoader.load(getClass().getResource("CommonPackageConfigurator.fxml"));
	
			Scene scene = new Scene(pPane,800,700);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Common Package Option Menu");

			stage.setScene(scene);

			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



}
