
import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.TabableView;
import javax.swing.text.html.parser.Parser;
import javax.xml.soap.Text;
import java.io.IOException;
import java.util.Observable;

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

        CheckBox urlConnectionCb = new CheckBox("URL Connection");
        CheckBox pageFoundCb = new CheckBox("Page Found");
        Label redirectLabel = new Label("");

        TableView table = new TableView();
        TableColumn usernameCol = new TableColumn("Username");
        TableColumn timeCol = new TableColumn("Timestamp");
        table.setEditable(true);
        table.getColumns().addAll(usernameCol,timeCol);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WikipediaPageParser parser = new WikipediaPageParser();
                PageOfRevisions page = parser.parseJsonFile(wikiPage.getText(), revisions.getText());

                urlConnectionCb.setSelected(parser.isConnected());

                pageFoundCb.setSelected(!page.isNotFound);

                redirectLabel.setText(page.isRedirected());

                ObservableList list = FXCollections.observableArrayList(page.getUserList());
                System.out.println(list);

                usernameCol.setCellValueFactory(
                        new PropertyValueFactory<User,String>("username")
                );
                timeCol.setCellValueFactory(
                        new PropertyValueFactory<Revision,String>("revisions")
                );


                table.setItems(list);

            }
        });
        parent.getChildren().add(button);
        parent.getChildren().add(urlConnectionCb);
        parent.getChildren().add(pageFoundCb);
        parent.getChildren().add(redirectLabel);
        parent.getChildren().add(table);
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}
