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

public class AddCurrentAccount implements Serializable 
{
	AddCurrentAccount()
	{
		Stage primary = new Stage();
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		
		Button bt = new Button("Add");
		
		Label l1 = new Label("Member Name");
		Label l2 = new Label("Account Balance");
		Label l3 = new Label("Trade License Number");
		
		bt.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				
				Main.bnk.addAccount(t1.getText(),Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText() ));
				Main.saveData(Main.bnk);
			}
			
		});
		
		VBox layout = new VBox();
		layout.setSpacing(10);
		t1.setMaxWidth(200);
		t2.setMaxWidth(200);
		t3.setMaxWidth(200);
		
		layout.setPadding(new Insets(40,0,0,130));
		layout.getChildren().addAll(l1,t1,l2,t2,l3,t3,bt);
		Scene sc = new Scene(layout,500,500);
		Stage newWindow = new Stage();
		newWindow.setTitle("Enter Your Current Account Data");
		newWindow.setScene(sc);
		
		newWindow.setX(primary.getX() + 350);
		newWindow.setY(primary.getY() + 0);
		
		newWindow.show();	
	}

}
