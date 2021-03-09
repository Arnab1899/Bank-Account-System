import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class depbtn implements Serializable
{
	depbtn()
	{
		Stage Stage=new Stage();
		
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
      
        Button add=new Button("Add");
        
        Label l1 = new Label("Enter Account Number");
        Label l2 = new Label("Enter Deposite Amount:");
       
      
        add.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent actionEvent) 
            {
                
				Main.bnk. deposit(tf1.getText(),Integer.parseInt(tf2.getText()) );
				Main.saveData(Main.bnk);
			
            }
        });

        VBox layout = new VBox();
        layout.setSpacing(10);
        
        
        tf1.setMaxWidth(180);
        tf2.setMaxWidth(180);
       
        layout.setPadding(new Insets(40,0,0,130));
        layout.getChildren().addAll(l1,tf1,l2,tf2,add);
        Scene SecondScene = new Scene(layout, 500, 500);
        Stage newWindow = new Stage();
        
        newWindow.setTitle("Enter Deposit Account Data");
        newWindow.setScene(SecondScene);
        
        newWindow.setX(Stage.getX() + 350);
        newWindow.setY(Stage.getY() + 0);

        newWindow.show();    
	}

}
