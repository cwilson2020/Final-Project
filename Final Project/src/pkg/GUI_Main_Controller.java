package pkg;




import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class GUI_Main_Controller {

	@FXML TextField tfName;
	@FXML private GridPane gPane;
	@FXML  Label lblfile;
	@FXML  Button btnfile;
	@FXML  Button btnfolder;


	public GUI_Main_Controller() {

	}



	public void onLoad() {

	}

	public void singleFileChooser(ActionEvent event){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("text files", "*.txt"));
		File f = fc.showOpenDialog(null);

		if(f !=null) {
			lblfile.setText("File: " + f.getAbsolutePath());
		}
	}

	public void directorychooser(ActionEvent event){
		DirectoryChooser directoryChooser = new DirectoryChooser();
		// Set title for DirectoryChooser
		directoryChooser.setTitle("Select Some Directories");

		// Set Initial Directory
		directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

		File dir = directoryChooser.showDialog(null);
		String s= dir.getAbsolutePath().toString();
		System.out.println(s);
	}

	public void buttonPress() {

		String s = tfName.getText();
		System.out.println(s);
		FileIO fio = new FileIO("C://Users//user//Desktop//database.xml");

		XML_IO x = new XML_IO();
		//x.launch();
		x.update();
		//x.getEntry();

		//	Scene scene = new Scene(gPane,400,400);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage = (Stage)gPane.getScene().getWindow();
		//stage.setScene(scene);
		stage.close();

	}



}
