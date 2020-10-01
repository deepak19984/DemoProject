package application;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NotepadController implements Initializable{
	@FXML
	MenuBar b;
	@FXML
	MenuItem it;
	@FXML
	TextArea ta;
	@FXML
	AnchorPane anchor;
	@FXML
	Label label1;
	
	File file;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ta.setPromptText("please write here");
		LocalDateTime dt=LocalDateTime.now();
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		 String formatDateTime = dt.format(format);  
		 label1.setText(formatDateTime);
		
	
		
	}
	public void save(ActionEvent e)
	{
		try {
			if(file!=null)
			{
				
				
				FileWriter fw=new FileWriter(file);
				String record=ta.getText();
				label1.setText(file.getName());
				fw.write(record);
				fw.close();
			}
			else
			{
				FileChooser f=new FileChooser();
				Stage stage=(Stage)anchor.getScene().getWindow();
				 file=f.showSaveDialog(stage);
				
				try {
					FileWriter fw=new FileWriter(file);
					String record=ta.getText();
					fw.write(record);
					label1.setText(file.getName());
					fw.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void saveAs(ActionEvent e1)
	{
		FileChooser f=new FileChooser();
		Stage stage=(Stage)anchor.getScene().getWindow();
		
		 file=f.showSaveDialog(stage);
		
		try {
			FileWriter fw=new FileWriter(file);
			String record=ta.getText();
			fw.write(record);
			fw.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	public void open(ActionEvent e2)
	{
		
		
		try {

			FileChooser f=new FileChooser();
			Stage stage=(Stage)anchor.getScene().getWindow();
			File file=f.showOpenDialog(stage);
			 FileReader fr = new FileReader(file);
			 BufferedReader br=new BufferedReader(fr);
		String line; 
			
			label1.setText(file.getName());
		 while ((line = br.readLine()) != null)  
	         {
	        	ta.setText(line);
	        	 fr.close();	        	
	        	
	         }
	        
	        
	         fr.close();   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		
         
	}
	public void delete(ActionEvent ev)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		alert.setHeaderText("Confirmation Alert");
		String s ="Do you want to delete file ";
		alert.setContentText(s);
		alert.show();
			
		
		file.delete();
		
			ta.setText("");
			label1.setText("");
	}
	public void about(ActionEvent evv)
	{
		
	}
	
	
	

}
