import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddAccount implements Serializable
{
	AddAccount()
	{
		Stage s = new Stage();
		VBox layout = new VBox();
		layout.setSpacing(10);
		
		
		Button AddSavingsAccount = new Button ("Saving Account");
		Button AddCurrentAccount = new Button ("Current Account");
		Button Exit = new Button("Exit");
		
		AddSavingsAccount.setStyle("-fx-background-color: #4682B4");
		AddCurrentAccount.setStyle("-fx-background-color: #4682B4");
		Exit.setStyle("-fx-background-color: #4682B4");
		
		AddSavingsAccount.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) 
			{
				new SavingsAccount(null,0,0);
				new AddSavingsAccount();
				
			}
			
		});
		
		AddCurrentAccount.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent actionEvent) 
			{
				new CurrentAccount(null,0,null);
				new AddCurrentAccount();
				
			}
			
		});
		
		Exit.setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				System.exit(0);
				
			}
			
		});
		
		AddSavingsAccount.setMaxSize(200, 200);
		AddCurrentAccount.setMaxSize(200,200);
		Exit.setMaxSize(200,200);
		
		layout.setPadding(new Insets(40,0,0,130));
		layout.getChildren().addAll(AddSavingsAccount,AddCurrentAccount,Exit);
		Scene s2 = new Scene (layout,500,250);
	    Stage newWindow = new Stage();
		newWindow.setTitle("Please Choose Your Option");
		
		newWindow.setScene(s2);
		newWindow.setX(s.getX() + 350);
		newWindow.setY(s.getY() + 0);
		
		newWindow.show();
		
		
	}

}
