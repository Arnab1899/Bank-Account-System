import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddLog implements Serializable
{
	AddLog()
	{
		
		Button withbtn = new Button("Withdraw Money");
		Button depbtn = new Button("Deposite Money");
		Button infobtn = new Button("Display Particular Account Information");
		Button allbtn  = new Button ("Display All Account Information");
		Button chkbtn  =  new Button("Check Balance");
		Button exbtn = new Button("Exit");
	
        withbtn.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent arg0) 
			{
				new withbtn();	
			}
        	
        });
        depbtn.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent arg0) 
			{
				new depbtn();
			}
        });
        infobtn.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent arg0) 
			{
				new allbtn();
				
			}
        	
        });
        allbtn.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent arg0) 
			{
				Main.bnk.display();	
				
			}
        	
        });
        
        chkbtn.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent arg0) 
			{
				new chkbtn();
			}
        	
        });
        
        exbtn.setOnAction(new EventHandler<ActionEvent>() 
        {

			@Override
			public void handle(ActionEvent actionEvent) 
			{
				System.out.println("Successfully Exit");
                System.exit(0);	
				
			}
        	
        });
        
        VBox layout = new VBox();
        layout.setSpacing(10);
        withbtn.setMaxSize(300,300);
		depbtn.setMaxSize(300,300);
		allbtn.setMaxSize(300,300);
		infobtn.setMaxSize(300,300);
		chkbtn.setMaxSize(300,300);
	    exbtn.setMaxSize(300,300);
	    
	    withbtn.setStyle("-fx-background-color: #778899");
	    depbtn.setStyle("-fx-background-color: #778899");
	    allbtn.setStyle("-fx-background-color: #778899");
	    infobtn.setStyle("-fx-background-color: #778899");
	    chkbtn.setStyle("-fx-background-color: #778899");
	    exbtn.setStyle("-fx-background-color: #778899");
	    
	    layout.setPadding(new Insets(40,30,40,80));
	    layout.getChildren().addAll(withbtn, depbtn, infobtn, allbtn, chkbtn, exbtn);
	    
	    Scene s  = new Scene (layout,500,500);
	    
        Stage newWindow = new Stage();
        newWindow.setTitle("Choose your Option");
        newWindow.setScene(s);
        newWindow.show();
        
	}

}
