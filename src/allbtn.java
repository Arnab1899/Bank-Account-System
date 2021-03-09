
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

public class allbtn implements Serializable
{
	allbtn()
	{
		Stage stage = new Stage();
		TextField tx = new TextField();
		Button add = new Button("Enter");
		Label l = new Label("Enter ID Number");
		
		add.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0) 
			{
				Main.bnk.display(tx.getText());	
				Main.saveData(Main.bnk);
			}
			
		});
		
		VBox layout = new VBox();
		layout.setSpacing(10);
        tx.setMaxWidth(100);
        
        layout.setPadding(new Insets(40,0,0,130));
        layout.getChildren().addAll(l,tx,add);
        Scene secondScene = new Scene(layout, 500, 500);
        
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter Requires Data");
        newWindow.setScene(secondScene);
        newWindow.setX(stage.getX() + 350);
        newWindow.setY(stage.getY() + 0);

        newWindow.show();	
	}

}


