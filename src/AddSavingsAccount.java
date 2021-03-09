import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddSavingsAccount implements Serializable
{
	AddSavingsAccount()
	{
		Stage primary = new Stage();
		
		TextField memberName = new TextField();
		TextField accountBalance  = new TextField();
		TextField maxLimit = new TextField();
		
		Button bn = new Button ("Add");
		
	    Label label1  = new Label("Member Name:");
		Label label2 = new Label("Account Balance:");
		Label label3 = new Label("Maximum Widthdraw Limit:");
		
		bn.setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				Main.bnk.addAccount(memberName.getText(),Integer.parseInt(accountBalance.getText()),Integer.parseInt(maxLimit.getText() ));
				Main.saveData(Main.bnk);
				
			}
		});
		
		VBox root = new VBox();
		root.setSpacing(10);
		memberName.setMaxWidth(200);
		accountBalance.setMaxWidth(200);
		maxLimit.setMaxWidth(200);
		
		root.setPadding(new Insets(40,0,0,130));
		root.getChildren().addAll(label1,memberName,label2,accountBalance,label3,maxLimit,bn);
		
		
        Scene SecondScene = new Scene(root, 500, 500);
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter SavingAccount Data");
        newWindow.setScene(SecondScene);
        newWindow.setX(primary.getX() + 350);
        newWindow.setY(primary.getY() + 0);

        newWindow.show();
	}

}
