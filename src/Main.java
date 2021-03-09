
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application 
{
   static String filename = "data.txt";
   
   public static void main(String[] args)
   {
	   Bank bank = readData();
	   Bank bank2  = saveData(bank);
	   
	   launch(args);
   } 
   
   static Bank bnk = new Bank();
  
	@Override
	public void start(Stage stage) throws Exception 
	{
		Button AddAccount = new Button ("Create Account");
		Button AddLog = new Button ("Login");
		Button Exit =  new Button ("Exit");
		
		//Bank bnk = new Bank();
		
		AddAccount.setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				new AddAccount();
				
			}
			
		});
		
		AddLog.setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				new AddLog();
				
			}
			
		});
		

		
		Exit.setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent actionEvent) 
			{
				// TODO Auto-generated method stub   
				saveData(bnk);
				System.out.println("Successfully Exit");
                System.exit(0);	
			}
			
		});
		
		VBox layout = new VBox();
		layout.setSpacing(10);
		
		Text t = new Text();
		t.setText("Bank Management System ");
		t.setFont(new Font(20));
		
		AddAccount.setMaxSize(300,300);
		AddLog.setMaxSize(300,300);
	    Exit.setMaxSize(300,300);
	    
	    AddAccount.setStyle("-fx-background-color: #B0C4DE");
	    AddLog.setStyle("-fx-background-color: #B0C4DE");
	    Exit.setStyle("-fx-background-color: #B0C4DE");
	    
	    
	    layout.setPadding(new Insets(40,30,0,90));
	    layout.getChildren().addAll(t,AddAccount,AddLog,Exit);
	    
	    Scene s  = new Scene (layout,500,500);
	    
	    stage.setTitle("Bank Managment System");
	    stage.setScene(s);
	    stage.show();
		
	}
	
	Bank bank = new Bank();
	
	private static Bank readData()
	{
		Bank bank =  new Bank(); 
		
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			bank = (Bank) ois.readObject();
		}
		catch (IOException | ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"No Data Availble Right Now.");
		}
		
		return bank;
	}
	
	public static Bank saveData(Bank b)
	{
		try
		{
			ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(filename));
			p.writeObject(b);
			p.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();	
		}
		return b;
	}
}

