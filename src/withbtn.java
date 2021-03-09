import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class withbtn implements Serializable
{
	withbtn()
	{
		Stage base = new Stage();
		
		TextField txt1 = new TextField();
		TextField txt2 = new TextField();
		
		Button add = new Button("Add");
		Label lib = new Label("Enter Account Name:");
		Label lib2 = new Label("Enter Withdraw Amount:");
		
		add.setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				Main.bnk.withdraw(txt1.getText(),Integer.parseInt(txt2.getText() ));
				Main.saveData(Main.bnk);
	
			}
				
		});
		
		
		VBox flag = new VBox();
		flag.setSpacing(10);
        txt1.setMaxWidth(150);
        txt2.setMaxWidth(150);
      
        flag.setPadding(new Insets(40,0,0,130));
        flag.getChildren().addAll(lib,txt1,lib2,txt2,add);
        Scene SecondScene = new Scene(flag, 500, 500);
        
        Stage newFile = new Stage();
        newFile.setTitle("Enter Withdraw Data");
        
        newFile.setScene(SecondScene);
        newFile.setX(base.getX() + 350);
        newFile.setY(base.getY() + 0);

        newFile.show();
		
	}

}
