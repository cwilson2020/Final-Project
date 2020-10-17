package pkg;




import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class GUI_Main_Controller {

	private static final boolean debug = true;
	@FXML TextField tfName;
	@FXML private GridPane gPane;
	@FXML Label lblfile;
	@FXML Label lblwarning;
	@FXML Button btnfile;
	@FXML Button btnfolder;
	@FXML Button btnButton;
	@FXML ChoiceBox<String> choicebox;
	@FXML RadioButton neworder;
	@FXML RadioButton existingorder;
	@FXML RadioButton radiocustomer;
	@FXML RadioButton radiodealer;
	@FXML Label lblName;


	//@FXML ChoiceBox choicebox;

	//@FXML GridPane gPane;
	String file;
	String path;
	JSONHolder jh;
	//AppModel appModel;


	public GUI_Main_Controller() {

		//choicebox.getSelectionModel().selectedItemProperty().addListener((v, OldValue, Newvalue) -> System.out.println("change"));
		//	appModel = new AppModel();
	}


	@FXML
	public void initialize() {

		System.out.println("Onload called");
		
		lblfile.setVisible(false);	
		btnfile.setVisible(false);
		neworder.setVisible(false);{
			existingorder.setVisible(false);
			btnfolder.setVisible(false);
			choicebox.setVisible(false);
			tfName.setVisible(false);
			btnButton.setVisible(false);
			lblName.setVisible(false);

			choicebox.getSelectionModel().selectedItemProperty().addListener((v, OldValue, Newvalue) ->{
				System.out.println("Choicebox changed");
				ChoiceboxAction();
			});
			neworder.selectedProperty().addListener(
					(ov, old_val, new_val) ->{
						if(new_val) {
							System.out.println("newOrderSelected");  
							choicebox.setVisible(false);
							btnfolder.setVisible(true);
							tfName.setDisable(false);
						}
					});


			existingorder.selectedProperty().addListener(
					(ov, old_val, new_val) ->{
						if(new_val) {
							System.out.println("existing OrderSelected");
							choicebox.setVisible(true);
							btnfolder.setVisible(false);
							tfName.setDisable(true);
						}
					});

			radiocustomer.selectedProperty().addListener((ov,old_val, new_val) ->{			 		
				lblfile.setVisible(true);
				tfName.setVisible(true);
				tfName.setDisable(false);
				btnfile.setVisible(true);

				if (neworder.isSelected()){
					btnfolder.setVisible(true);
					choicebox.setVisible(false);
				}
				else {
					btnfolder.setVisible(false);
					choicebox.setVisible(true);
				}
				neworder.setVisible(true);
				existingorder.setVisible(true);

			});

			radiodealer.selectedProperty().addListener((ov,old_val, new_val) ->{			 		
				lblName.setVisible(true);	
				lblfile.setVisible(true);	
				btnfile.setVisible(true);
				neworder.setVisible(false);
				existingorder.setVisible(false);
				btnfolder.setVisible(true);
				//choicebox.setVisible(true);
				tfName.setVisible(true);
				tfName.setDisable(true);


			});

		}
	}


	public void singleFileChooser(ActionEvent event){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("text files", "*.txt"));
		File f = fc.showOpenDialog(null);

		if(f !=null) {
			lblfile.setText("File: " + f.getAbsolutePath());
			file =  f.getAbsolutePath();
			PopulateChoiceBox();
		}
		choicebox.setVisible(true);
		//neworder.setVisible(true);
		//existingorder.setVisible(true);
		AppModel.setFile(f);

	}

	public void directorychooser(ActionEvent event){
		DirectoryChooser directoryChooser = new DirectoryChooser();
		// Set title for DirectoryChooser
		directoryChooser.setTitle("Select Some Directories");

		// Set Initial Directory
		directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

		File dir = directoryChooser.showDialog(null);
		path = dir.getAbsolutePath().toString();
		path =  path + "\\database.txt";
		System.out.println(path);
		lblfile.setText("File: " + dir.getAbsolutePath());
		path = dir.getAbsolutePath();
		FileIO.Createfile(path);
		AppModel.setFile(dir);

	}


	public void PopulateChoiceBox() {
		JParser jp = new JParser();
		jh = jp.CreateOrderArrayfromFile(file);

		ObservableList<String> list = FXCollections.observableArrayList();

		JSONIter ji = new JSONIter(jh.getOrder());

		while( ji.hasNext()){			
			Order order =ji.next();
			list.add(String.valueOf("Order ID: " + order.getId()) );			
		}


		choicebox.setDisable(false);
		list.add("Select Order");
		choicebox.setItems(list);
		choicebox.setValue("Select Order");
		AppModel.setJh(jh);

	}

	public void existingRadioActions() {
		btnfolder.setVisible(false);
	}

	public void ChoiceboxAction() {
		if(!choicebox.getValue().toString().equals("Select Order") && (choicebox.getValue()!= null)){
			int index = choicebox.getSelectionModel().getSelectedIndex();
			Order order = jh.getByIndex(index); 
			//	Order o = JParser.retrieveOrderByID(jh, choicebox.getValue().toString());
			tfName.setText(order.getName());
			AppModel.setOrder(order);
		}
		else {
			tfName.setText("");
		}
	}


	public void buttonPress() {
		Stage stage = (Stage)gPane.getScene().getWindow();


		if(tfName.getText().equals("Enter Name") ) {//|| tfName.getText().equals("")){
			lblwarning.setText("Name Field needs to be properly filled out.");				
		}

		else if (choicebox.getValue().toString().equals("Select Order")
				&& existingorder.isSelected())

		{
			lblwarning.setText("Existing Order must be selected");
			//	choicebox.setValue("Make a Selection");
		}

		else if(lblfile.getText().equals("No File Chosen")){
			lblwarning.setText("A valid file is needed to continue");
		}


		else {		
			String user;
			String status;
			OrderInfo oi = new OrderProxy();
			if(radiodealer.isSelected())
			user="Dealer";
			else user="Customer";
			
			if(neworder.isSelected())
				status = "Open";
			else
				status = AppModel.getOrder().getStatus();				
			oi.setstatus(user, status);
			

			AnchorPane aPane;
			//GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("MainInputPane.fxml"));
			try {

				/*GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("MainInputPane.fxml"));

				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);*/
				stage.close();



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
		}

	}



}
