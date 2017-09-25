
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.html.parser.Parser;
import javax.xml.soap.Text;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox parent = new VBox();
        parent.getChildren().add(new Label(("What page would you like to search?")));

        HBox number = new HBox(new Label("Number: "));
        TextField wikiPage = new TextField();
        parent.getChildren().add(wikiPage);
        parent.getChildren().add(new Label("How many revisions would you like to see?"));
        TextField revisions = new TextField();
        parent.getChildren().add(revisions);

        Button button = new Button("Get Revisions!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("I love this");
            }
        });
        parent.getChildren().add(button);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}
