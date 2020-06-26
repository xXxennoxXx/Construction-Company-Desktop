package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

public class Run extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

//            JMetro jMetro = new JMetro(Style.DARK);

            Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
            Scene scene = new Scene(root);
            //TODO CZy isnieje zbiór gotowych motywów? (DARK)
            scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
            primaryStage.setScene(scene);

//            jMetro.setScene(scene);
            primaryStage.setTitle("Construction Company");
//TODO Odcięcia tła?
            String s = getClass().getResource("/icon.png").toString();

            primaryStage.getIcons().add(new Image(s));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
