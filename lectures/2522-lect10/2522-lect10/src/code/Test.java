import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application
{
    @Override
    public void start(final Stage primaryStage) {
        TextField textField = new TextField();
        textField.setPromptText("Type something here");

        Label label = new Label("Your text will appear here");

        Button button = new Button("Show Text");

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Options");
        MenuItem showTextItem = new MenuItem("Show Text");
        menu.getItems().add(showTextItem);
        menuBar.getMenus().add(menu);

        button.setOnAction(event -> {
            label.setText(textField.getText());
        });

        showTextItem.setOnAction(event -> {
            label.setText(textField.getText());
        });

        VBox root = new VBox();
        root.setSpacing(10);
        root.getChildren().addAll(menuBar, textField, button, label);

        Scene scene = new Scene(root, 350, 200);

        primaryStage.setTitle("Simple JavaFX App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}