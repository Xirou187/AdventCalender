package htl.steyr.adventcalender;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AdventCalendarApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        int numRows = 4;
        int numCols = 6;

        for (int i = 1; i <= 24; i++) {
            Button button = new Button(String.valueOf(i));
            button.setMinSize(100, 100);
            button.setOnAction(event -> openImage(button.getText()));

            grid.add(button, (i - 1) % numCols, (i - 1) / numCols);
        }

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setTitle("Adventskalender");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openImage(String day) {
        String imagePath = "/images/day" + day + ".jpg"; // Ensure your images are in src/main/resources/images
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);

        Stage imageStage = new Stage();
        StackPane imagePane = new StackPane(imageView);
        Scene imageScene = new Scene(imagePane, 400, 400);
        imageStage.setScene(imageScene);
        imageStage.setTitle("Bild für Tag " + day);
        imageStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    //
}
